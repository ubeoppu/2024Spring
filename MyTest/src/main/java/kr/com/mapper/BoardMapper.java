package kr.com.mapper;

import java.util.List;

import kr.com.dto.BoardDTO;

public interface BoardMapper {
	
	public int insertBoard(BoardDTO dto);
	
	public BoardDTO selectOneBoard(String name);
	
	public int deleteBoard(String name);
	
	public int updateBoard(BoardDTO dto);
	
	public List<BoardDTO> selectBoardList();

}
