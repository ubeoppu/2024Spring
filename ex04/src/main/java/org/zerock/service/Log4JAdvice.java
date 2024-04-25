package org.zerock.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Aspect
@Service
@Log4j
public class Log4JAdvice implements Advice{
	
	@Pointcut("execution(* org.zerock.service.ReplyServiceImpl.*(..) )") //1
	public void allPointCut() {};

	
	@After("allPointCut()") //메서드 동작 이후 찍어줌
	public void logAdvice() {
		log.info("[ReplyController] 로그 기록 ===================");
		
	}

	@Override
	public void advice() {
		log.info("[ReplyController]로그 기록====================");
		
	}
	
}
