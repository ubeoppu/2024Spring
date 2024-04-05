package kr.com.ezen.mapper;

import java.util.List;

import kr.com.ezen.dto.MemberVO;

public interface MemberMapper {
	
	public int insertMember(MemberVO vo);
	
	public List<MemberVO> selectMemberList();

}
