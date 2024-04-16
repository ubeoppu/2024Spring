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
public class MemberMapperTests {
	
	@Autowired
	private MemberMapper mapper;

	@Test
	public void insertMemberTestss() {
		log.info("test..insert");
		
		MemberVO vo = MemberVO.builder()
				.userId("test5")
				.name("test5")
				.password("test5")
				.phone("010-5555-5555")
				.address("경기 북부")
				.build();
		
		mapper.insertMember(vo);
		log.info(vo);
	}
	
	@Test
	public void deleteMemberTest() {
		log.info("test...delete");
		
		String userId = "test5";
		
		mapper.deleteMember(userId);
		
		
	}
}
