package kr.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kr.com.dao.MemberDAO;
import kr.com.domain.MemberVO;
import kr.com.mail.MailHandler;
import kr.com.mail.TempKey;
import kr.com.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	//생성자 주입
	private final MemberMapper mapper;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void createMember(MemberVO vo) throws Exception {
		
		String mail_key = new TempKey().getKey(30, false);
		vo.setMail_key(mail_key);;
		
		mapper.createMember(vo);
		mapper.updateMailKey(vo);
		
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("[테스트 인증 메일 입니다.]");
		sendMail.setText(
				"<h1>테스트 메일 인증</h1>" +
		        "<br>테스트 ... 입니다" +
				"<br>아래 [이메일 인증 확인]을 눌러주세요." +
		        "<br><a href='http://localhost:8181/join/registerEmail?email=" + vo.getEmail() +
		        "mail_key=" + mail_key +
		        "'target='_blank'>이메일 인증 확인</a>");
				sendMail.setFrom("ubeoppu@gmail.com", "임재현");
				sendMail.send();
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
