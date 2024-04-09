package kr.com.service;

import java.util.List;

import kr.com.dto.BoardDTO;

public interface BoardService {

	public void insertBoard(BoardDTO dto);
	
	public BoardDTO selectOneBoard(String name);
	
	public List<BoardDTO> selectBoardList();
	
	public boolean deleteBoard(String name);
	
	public boolean updateBoard(BoardDTO dto);
	
	
}
