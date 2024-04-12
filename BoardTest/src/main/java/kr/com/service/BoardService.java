package kr.com.service;

import java.util.List;

import kr.com.domain.BoardVO;

public interface BoardService {
	
	public void insertBoard(BoardVO vo);
	
	public boolean deleteBoard(int bno);
	
	public boolean updateBoard(BoardVO vo);
	
	public BoardVO selectOneBoard(int bno);
	
	public List<BoardVO> BoardList();

}
