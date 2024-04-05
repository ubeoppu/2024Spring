package kr.com.ezen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
public class MemberVO {

	private int id;
	private String name;
	private String phone;
	private String address;
}
