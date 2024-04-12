package kr.com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.com.domain.BoardVO;
import kr.com.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BoardServiceImpl implements BoardService{
	
	//생성자 주입
	private final BoardMapper mapper;

	@Override
	public void insertBoard(BoardVO vo) {
		mapper.insertBoard(vo);
		
	}

	@Override
	public boolean deleteBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return mapper.updateBoard(vo) == 1;
	}

	@Override
	public BoardVO selectOneBoard(int bno) {
		return mapper.selectOneBoard(bno);
	}
	
	@Override
	public List<BoardVO> BoardList() {
		return mapper.BoardList();
	}
	
	

}
