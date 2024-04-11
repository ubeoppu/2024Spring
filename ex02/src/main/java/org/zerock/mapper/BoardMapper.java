package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	public List<BoardVO> getList();
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public boolean update(BoardVO boardVO);
	
	public boolean delete(Long bno);

}
