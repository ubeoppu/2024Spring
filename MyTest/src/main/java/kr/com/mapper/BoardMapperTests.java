package kr.com.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.dto.BoardDTO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	
	@Autowired
	private BoardMapper mapper;
	
	
	@Test
	public void insertBoard() {
		BoardDTO dto = BoardDTO.builder()
				.name("김성준")
				.title("제목1")
				.content("내용입니다.")
				.build();
		
		int result = mapper.insertBoard(dto);
		log.info(result);
		
	}
	
	@Test
	public void selectOneBoard() {
		String name = "김성준";
		
		BoardDTO dto = mapper.selectOneBoard(name);
		
		log.info(dto);
		
	}
	
	@Test
	public void selectBoardList() {
		List<BoardDTO>list = new ArrayList<BoardDTO>();
		
		list = mapper.selectBoardList();
		
		log.info(list);
		
	}
	
	@Test
	public void updateBoard() {
		BoardDTO dto = BoardDTO.builder()
				.name("임재현")
				.title("수정된 제목")
				.content("수정된 내용")
				.build();
		
		int result = mapper.updateBoard(dto);
		
		log.info(result);
	}
	
	@Test
	public void deleteBoard() {
		String name="임재현";
		
		int result = mapper.deleteBoard(name);
		log.info(result);
	}

}
