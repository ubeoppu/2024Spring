package kr.trip.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.trip.domain.AuthVO;
import kr.trip.domain.MemberVO;
import kr.trip.domain.TravelPlanVO;

public interface MemberService {

	public MemberVO read(String member_email);
	
	public void register(MemberVO member);
	
	public void insertAuth(AuthVO auth);
	
	public boolean selectId(String id);
	
	public List<String> findId(String name, String phone);
	
	public boolean update(MemberVO member);

	   // 개인정보 마이페이지 출력
	   public List<MemberVO> viewMember(String member_email);

	         
	   // 여행정보 마이페이지 출력
	   
	   public List<TravelPlanVO> viewPlan(String member_email);
	            

	   public void saveProfileImage(String member_email, MultipartFile file);

}