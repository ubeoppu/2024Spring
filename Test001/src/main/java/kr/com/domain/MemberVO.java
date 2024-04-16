package kr.com.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberVO {
	
	private String userId;
	private String name;
	private String password;
	private String phone;
	private String address;

}
