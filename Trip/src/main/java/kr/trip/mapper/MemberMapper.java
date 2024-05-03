package kr.trip.mapper;

import java.util.List;

import kr.trip.domain.AuthVO;
import kr.trip.domain.MemberVO;

public interface MemberMapper {
   
   public MemberVO read(String member_email);
   
   public void insert(MemberVO member);
   
   public void insertAuth(AuthVO auth);
   
   public List<MemberVO>getListMember();
   
   public void deleteMember(String member_email);
   
   /*
    * public int update(MemberVO member);
    * 
    * public int delete(String member_email);
    * 
    * public int getAmount();
    */
}