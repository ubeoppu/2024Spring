package kr.com.mapper;

import java.util.List;

import kr.com.domain.BoardVO;

public interface BoardMapper {
	
	public void insertBoard(BoardVO vo);
	
	public BoardVO selectOneBoard(int bno);
	
	public List<BoardVO> BoardList();
	
	public int updateBoard(BoardVO vo);
	
	public int deleteBoard(int bno);

}
