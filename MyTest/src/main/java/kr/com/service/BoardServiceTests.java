package kr.com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.com.dto.BoardDTO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardServiceTests {
	
	@Autowired //필드 주입
	private BoardService service;
	
	@Test
	public void testinsertMember() {
		BoardDTO dto = BoardDTO.builder()
				.name("조영빈")
				.title("k77")
				.content("조종수")
				.build();
		
		service.insertBoard(dto);
		
		log.info(dto);
		
	}

}
