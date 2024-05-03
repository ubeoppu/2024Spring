package kr.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.trip.domain.HelpVO;
import kr.trip.domain.MemberVO;
import kr.trip.mapper.HelpMapper;
import kr.trip.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

	private final MemberMapper membermapper;
	
	private final HelpMapper helpmapper;
	
	@Override
	public List<MemberVO> getListMember() {
		return membermapper.getListMember();
	}

	@Override
	public void deleteMember(String member_email) {
		membermapper.deleteMember(member_email);
		
	}

	@Override
	public List<HelpVO> getListHelp() {
		return helpmapper.getListHelp();
	}

	@Override
	public HelpVO readHelp(int help_id) {
		return helpmapper.readHelp(help_id);
	}
	

}
