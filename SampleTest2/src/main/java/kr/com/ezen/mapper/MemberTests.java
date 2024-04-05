package kr.com.ezen.mapper;

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
public class MemberTests {
	
	@Autowired
	private MemberMapper mapper;
	
	
	@Test
	public void testInsert() {
		
		MemberVO vo = MemberVO.builder()
				.id(2)
				.name("임재현2")
				.phone("010-1111-2221")
				.address("경기도 수원")
				.build();
		
		log.info(mapper.memberInsert(vo));
	}
	@Test
	public void testUpdate() {
	
		MemberVO vo = MemberVO.builder()
				.id(1)
				.name("임재현2")
				.phone("010-5633-2222")
				.address("테스트")
				.build();
		mapper.memberUpdate(vo);
	}
	
	@Test
	public void testDelete() {
		log.info(mapper.memberDelete(1));
	}
	
	@Test
	public void testSelectOneMember() {
		MemberVO vo =mapper.selectOneMember(1);
		
		log.info(vo);
	}
	
	@Test
	public void testSelectMemberList() {
	List<MemberVO> list = mapper.selectMemberList();
	log.info(list);
	}
	

}
