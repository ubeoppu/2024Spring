package kr.trip.mapper;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.trip.domain.Criteria;
import kr.trip.domain.HelpVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HelpMapperTests {
	
	@Autowired
	private HelpMapper helpmapper;
	
	@Test
	public void insertHelpTest() {
		HelpVO vo = HelpVO.builder()
				.help_id(5)
				.member_email("test1234")
				.title("라스트 테스트")
				.content("테스트내용")
				.build();
		log.info(vo);
		
		helpmapper.insertHelp(vo);
		
		log.info(vo);
	}
	
	@Test
	public void readHelpTest() {
		HelpVO vo = helpmapper.readHelp(4);
		
		log.info(vo);
	}
	
	@Test
	public void updateHelpTest() {
		HelpVO vo = HelpVO.builder()
				.title("수정된 제목")
				.content("수정된 내용")
				.help_id(4)
				.build();
		log.info(vo);
	helpmapper.updateHelp(vo);
	}
	
	@Test
	public void deleteHelpTest() {
	log.info(helpmapper.deleteHelp(4));
	}
	
	@Test
	public void getListHelpTest() {
		helpmapper.getListHelp().forEach(result -> log.info(result));
	}
	
	@Test
	public void pagingTest() {
	
	
	

}
