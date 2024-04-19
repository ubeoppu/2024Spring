package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[]bnoArr = {1507336L,1507337L, 1507338L, 1507339L, 1507340L};
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void testMapper() {
		log.info(replyMapper);
	}
	//C
	@Test
	public void testCreate() {
		
		IntStream.range(1, 101).forEach(i -> { 
		
		ReplyVO vo= ReplyVO.builder()
				.bno(bnoArr[i%5])
				.reply("댓글 테스트")
				.replyer("임재현")
		        .build();
		
		replyMapper.insert(vo);
		});
	}
	//R
	@Test
	public void testRead() {
		log.info(replyMapper.read(150L));
	}
	//U
	@Test
	public void testUpdate() {
		ReplyVO vo = ReplyVO.builder()
				.rno(105L)
				.reply("수정 테스트")
				.build();
		
		log.info(replyMapper.update(vo));
	}
	
	//D
	@Test
	public void testDelete() {
		
		log.info(replyMapper.delete(102L));
	}
	
	@Test
	public void getGetList() {
		Criteria cri = new Criteria();
		List<ReplyVO> list = replyMapper.getListWishPaging(cri, bnoArr[0]);
		
		list.forEach(reply -> log.info(reply));
		
		
		
	}

}
