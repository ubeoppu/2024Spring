package com.test.ezen;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.ezen.dto.MemberVO;
import com.test.ezen.mapper.TestMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestMapperTests {
	
	@Autowired
	private TestMapper testMapper;
	
	@Test
	public void inserMember() {
		MemberVO vo = MemberVO.builder()
				.id(21)
				.name("몰라")
				.phone("010101010")
				.address("비밀임")
				.build();
	int result = testMapper.insertMember(vo);	
	log.info(result);
	}

}
