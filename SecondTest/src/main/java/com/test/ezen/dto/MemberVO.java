package com.test.ezen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter
@Builder
@AllArgsConstructor
public class MemberVO {

	private int id;
	private String name;
	private String phone;
	private String address;
}
