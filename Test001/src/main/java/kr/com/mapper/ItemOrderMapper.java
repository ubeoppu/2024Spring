package kr.com.mapper;

import kr.com.domain.ItemOrderVO;

public interface ItemOrderMapper {
	
	public int insertItemOrder(ItemOrderVO vo);
	
	public int deleteItemOrder(int ono);

}
