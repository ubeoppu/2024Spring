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
	public void insertMemberTest() {
		
		MemberVO vo = MemberVO.builder()
				.userID("qq22457")
				.userPW("1234")
				.phone("010-2222-2222")
				.email("wogusdl0622@naver.com")
				.address("경기 수원쪽")
				.build();
		
	log.info(vo);
	
    log.info("test..!" + mapper.insertMember(vo));
		
	}
	
	
	
	
	
	

}
