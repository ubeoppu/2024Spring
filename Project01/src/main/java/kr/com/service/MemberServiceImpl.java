package kr.com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.com.domain.MemberVO;
import kr.com.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	//생성자 주입
	private final MemberMapper mapper;
	
	@Override
	public int createMember(MemberVO vo) {
		return mapper.createMember(vo);
	}

	@Override
	public MemberVO getMember(String id) {
		return mapper.getMember(id);
	}

	@Override
	public List<MemberVO> getMemberList() {
		return mapper.getMemberList();
	}

	@Override
	public int updateMember(MemberVO vo) {
		return mapper.updateMember(vo);
	}

	@Override
	public int deleteMember(String id) {
		return mapper.deleteMember(id);
	}

	@Override
	public int updateMailKey(MemberVO vo) throws Exception {
		return mapper.updateMailKey(vo);
	}

	@Override
	public int updateMailAuth(MemberVO vo) throws Exception {
		return mapper.updateMailAuth(vo);
	}

	@Override
	public int emailAuthFail(String id) throws Exception {
		return mapper.emailAuthFail(id);
	}

}
