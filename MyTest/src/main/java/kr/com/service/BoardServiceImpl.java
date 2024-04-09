package kr.com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.com.dto.BoardDTO;
import kr.com.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor

public class BoardServiceImpl implements BoardService{

	//생성자 주입
	private final BoardMapper mapper;
	
	
	@Override
	public void insertBoard(BoardDTO dto) {
		log.info("insert..");
		mapper.insertBoard(dto);
		
	}


	@Override
	public BoardDTO selectOneBoard(String name) {
		log.info("selectOneBoard...");
		
		return mapper.selectOneBoard(name);
	}


	@Override
	public List<BoardDTO> selectBoardList() {
		log.info("selectBoardList...");
		return mapper.selectBoardList();
	}


	@Override
	public boolean deleteBoard(String name) {
		log.info("delte..." + name);
		return mapper.deleteBoard(name) == 1;
	}


	@Override
	public boolean updateBoard(BoardDTO dto) {
		log.info("update..." + dto);
		
		return mapper.updateBoard(dto) == 1;
	}
	
	

}
