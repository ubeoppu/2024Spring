package kr.trip.service;

import java.util.List;

import kr.trip.domain.HelpVO;
import kr.trip.domain.MemberVO;

public interface AdminService {
	
	public List<MemberVO> getListMember();
	
	public void deleteMember(String member_email);

	public List<HelpVO> getListHelp();
	
	public HelpVO readHelp(int help_id);
}
