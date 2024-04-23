package kr.com.mapper;

import java.text.SimpleDateFormat;
import java.util.List;

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
	
	@Autowired //필드 주입
	private MemberMapper mapper;
	
	SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
	String dateString = "940501";
	
	
	@Test
	public void insertMember() {
		try {
		MemberVO vo = MemberVO.builder()
				.id("qq224571")
				.pwd("1234")
				.email("wowlswoguswo@naver.com")
				.name("임재현")
				.phone("010-1111-1111")
				.address("경기도 수원시")
				.zipCode(15555)
				.detailAddress("금곡 신미주 아파트")
				.extraAddress("테스트")
				.gender("남자")
				.birth("010622")
				.build();
		
		log.info(vo);
		
		mapper.createMember(vo);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteMemberTest() {
		mapper.deleteMember("qq22457");
	}
	
	@Test
	public void updateMemberTest() {
		MemberVO vo = MemberVO.builder()
				.id("pp22457")
				.pwd("1234")
				.email("ubeoppu@naver.com")
				.phone("010-2478-3348")
				.address("경기도 수원시")
				.zipCode(15555)
				.detailAddress("금곡 신미주 아파트")
				.build();
		mapper.updateMember(vo);
	}
	
	@Test
	public void getMemberTest() {
	 log.info(mapper.getMember("qq22457"));
	}
	
	@Test
	public void getMemberList() {
		List<MemberVO> list =mapper.getMemberList();
		
	list.forEach(vo->log.info(vo));
	}
	
	
	

}
