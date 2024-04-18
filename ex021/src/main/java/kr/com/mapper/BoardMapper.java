package kr.com.mapper;

import java.util.List;
import java.util.Map;

import kr.com.domain.BoardVO;
import kr.com.domain.Criteria;

public interface BoardMapper {
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	
	public List<BoardVO> searchTest(Map<String, Map<String, String>> map);

}
