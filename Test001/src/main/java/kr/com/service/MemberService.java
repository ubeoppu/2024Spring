package kr.com.service;

import kr.com.domain.MemberVO;

public interface MemberService {
	
	public void registerMember(MemberVO vo);
	
	public boolean removeMember(String userId);

	
}
