package kr.com.service;

import java.util.List;

import kr.com.domain.MemberVO;

public interface MemberService {

	public int createMember(MemberVO vo);
	public MemberVO getMember(String id);
	public List<MemberVO> getMemberList();
	public int updateMember(MemberVO vo);
	public int deleteMember(String id);
	public int updateMailKey(MemberVO vo)throws Exception;
	public int updateMailAuth(MemberVO vo)throws Exception;
	public int emailAuthFail(String id) throws Exception;
}
