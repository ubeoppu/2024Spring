package kr.com.ezen.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
@Component
public class MemberMapperTests {
	
	
	
	
	@Autowired
	private MemberMapper mapper;	
	
	@Test
	public void insertMember() {
		
		MemberVO vo= MemberVO.builder()
				.id(9)
				.name("임재현")
				.phone("010-2478-3348")
				.address("경기도수원시")
				.build();
		mapper.insertMember(vo);
		log.info("vo>>" + vo);
	}
	
	@Test
	public void selectMemberList() {
		
		List<MemberVO> list = mapper.selectMemberList();
		list.forEach(vo -> log.info(vo));
		
		
	}

}
