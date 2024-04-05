package kr.com.ezen.service;

import java.util.List;

import kr.com.ezen.dto.MemberVO;

public interface MemberService {
	
	public int insertMember1(MemberVO vo);
	
	public List<MemberVO>selectAllMember();

}
