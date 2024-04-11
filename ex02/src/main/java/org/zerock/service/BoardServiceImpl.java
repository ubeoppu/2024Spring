package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	//객체에 올라와있는 BoardMapper의 주소값을 사용
	private final BoardMapper boardMapper;
	
	@Override
	public void register(BoardVO board) {
		boardMapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		
		return boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return boardMapper.update(board);
	}

	@Override
	public boolean remove(Long bno) {
		return boardMapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return boardMapper.getList();
	}

}
