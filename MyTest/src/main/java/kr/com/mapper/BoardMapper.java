package kr.com.mapper;

import kr.com.dto.BoardDTO;

public interface BoardMapper {
	
	public int insertBoard(BoardDTO dto);
	
	public void selectOneBoard(String name);

}
