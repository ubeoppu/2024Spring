package kr.com.ezen.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j


public class MemberServiceTests {
	
	@Autowired
	private MemberService memberService;

	@Test
	public void testInsert() {
		MemberVO vo = MemberVO.builder()
				.id(3)
				.name("김정민")
				.phone("010-3333-4444")
				.address("서울시 도곡동")
				.build();
		
		memberService.insertMember(vo);
		
	}
	
	@Test
	public void testList() {
		List<MemberVO>list=memberService.list();
		
		for(MemberVO vo : list) {
		log.info(vo);	
		}
		
		
		//람다식
//		.forEach(vo -> log.info(vo));
	}

}
