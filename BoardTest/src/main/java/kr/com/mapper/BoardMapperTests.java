package kr.com.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.domain.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void insertBoardTest() {
		BoardVO vo = BoardVO.builder()
				.name("이름44")
				.title("2제목")
				.content("44용")
				.build();
		
		mapper.insertBoard(vo);
				
	}
	
	@Test
	public void updateBoardTest() {
		BoardVO vo = BoardVO.builder()
				.bno(2)
				.title("수정")
				.content("수정")
				.build();
		mapper.updateBoard(vo);
	}
	
	@Test
	public void deleteBoardTest() {
		int bno = 2;
		mapper.deleteBoard(bno);
	}
	
	@Test
	public void selectOneBoardTest() {
		int bno = 3;
		BoardVO vo = mapper.selectOneBoard(bno);
		log.info("-------------");
		log.info(vo);
		log.info("--------------");
		
	}
	
	@Test
	public void BoardList() {
//		mapper.BoardList().forEach(vo -> log.info(vo));
		
		List<BoardVO>list=mapper.BoardList();
		
		for(BoardVO vo : list) {
			log.info(vo);
		}
		
		
	}
	
	

}
