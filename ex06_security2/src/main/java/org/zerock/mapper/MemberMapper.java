package org.zerock.mapper;

import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	
	public void insert(MemberVO memberVO);
	
	public void insertAuth(AuthVO auth);
	
	public MemberVO read(String userid);

}
