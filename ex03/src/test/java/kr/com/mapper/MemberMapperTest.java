package kr.com.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.domain.MemberVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper mapper;
	
	
	@Test
	public void memberInsertTests() {
		log.info("insert...");
		
		MemberVO vo = MemberVO.builder()
				.userId("test5")
				.name("test4")
				.password("test1234")
				.phone("010-4444-4444")
				.address("경기북부")
				.build();
		
		mapper.insertMember(vo);
	}
	
}
