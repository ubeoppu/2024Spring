package kr.com.ezen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.com.ezen.dto.MemberVO;

public interface MemberMapper {
	
	@Select("SELECT SYSDATE FROM dual")
	public String getTime();
	
	
	public String getTime2();
	
	public int memberInsert(MemberVO vo);
	
	public int memberUpdate(MemberVO vo);
	
	public int memberDelete(int id);
	
	public MemberVO selectOneMember(int id);
	
	public List<MemberVO>selectMemberList();

}
