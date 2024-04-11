package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService boardService;
	
	@Test
	public void testRegister() {
		BoardVO board = BoardVO.builder()
				.title("추가한 제목2")
				.content("추가 내용")
				.writer("저자")
				.build();
		boardService.register(board);
		
		log.info("생성된 게시물 번호" + board.getBno());
	}
}
