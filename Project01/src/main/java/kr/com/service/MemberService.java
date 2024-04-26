package kr.com.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import kr.com.domain.MemberVO;

public interface MemberService {

	public void createMember(MemberVO vo)throws Exception;
	public MemberVO getMember(String id);
	public List<MemberVO> getMemberList();
	public int updateMember(MemberVO vo);
	public int deleteMember(String id);
	public int updateMailKey(MemberVO vo)throws Exception;
	public int updateMailAuth(MemberVO vo)throws Exception;
	public int emailAuthFail(String id) throws Exception;
}
