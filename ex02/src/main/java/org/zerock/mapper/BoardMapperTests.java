package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		
		boardMapper.getList().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = BoardVO.builder()
				.title("새로작성하는글2")
				.content("새로 잓어하는 내용")
				.writer("newbie2")
				.build();
		
		boardMapper.insertSelectKey(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = boardMapper.read(9L);
		
		log.info(board);
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = BoardVO.builder()
				.bno(2)
				.title("수정 제목")
				.content("수정 내용")
				.writer("수정 작가")
				.build();
	
		boardMapper.update(board);
		
	}

}
