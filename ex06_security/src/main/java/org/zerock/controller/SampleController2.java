package org.zerock.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample/*")
public class SampleController2 {
	
	@GetMapping("/all") //모든 사용자가 호출 가능
	public void doAll() {
		log.info("all.......");
	}
	@GetMapping
	public void doMember() { //멤버 회원들만 호출 가능
		log.info("Member...");
	}
	
	@GetMapping("/admin") //관리자만 호출 가능
	public void doAdmin() {
		log.info("admin....");
	}

}
