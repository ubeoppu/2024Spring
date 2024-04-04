package kr.com.ezen.persistence;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.ezen.dto.MemberVO;
import kr.com.ezen.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void testGetTime() {
		log.info("--------------------------------");
		log.info(memberMapper.getClass().getName());
		log.info(memberMapper.getTime());
		log.info("--------------------------------");
	}
	
	@Test
	public void testInsertMember() {
//		MemberVO vo = new MemberVO();
//		vo.setId(1);
//		vo.setName("이름");
//		vo.setPhone("전화번호");
//		vo.setAddress("주소");
		
		for(int i=0; i<10; i++) {
		MemberVO vo = MemberVO.builder()
				.id(10 + i)
				.name("관우" + i)
				.phone("010-4242-4242" +  i)
				.address("경기도 수원" + i)
				.build();
		memberMapper.insertMember(vo);
		}
		
	}
	
	@Test
	public void testUpdateMember() {
		
		MemberVO vo = MemberVO.builder()
				.id(11)
				.name("테스트")
				.phone("010-1111-2222")
				.address("경기도 화성")
				.build();
		memberMapper.updateMember(vo);
	}
	
	@Test
	public void testDeleteMember() {
		memberMapper.deleteMember(13);
		
	}
	
	@Test
	public void testSelectOneMember() {
		MemberVO vo =memberMapper.selectOneMember(13);
		log.info("vo>>>>" + vo);
	}
	@Test
	public void testSelectAllMember() {
		List<MemberVO> list = memberMapper.selectAllMember();
		for(MemberVO vo: list) {
		log.info(vo);	
		
//		memberMapper.selectAllMember()
//		.forEach(vo-> log.info(vo));
//		}
}
	}
	}
