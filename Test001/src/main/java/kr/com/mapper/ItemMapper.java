package kr.com.mapper;

import kr.com.domain.ItemVO;

public interface ItemMapper {
	
	public int insertItem(ItemVO vo);
	
	public int deleteItem(int ino);

}
