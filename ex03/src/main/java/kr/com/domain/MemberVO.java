package kr.com.domain;
//CREATE TABLE MEMBER(
//USERID VARCHAR(30) NOT NULL PRIMARY KEY,
//NAME VARCHAR(12) NOT NULL,
//PASSWORD VARCHAR(30) NOT NULL,
//PHONE VARCHAR(50) NOT NULL,
//ADDRESS VARCHAR(30) NOT NULL
//);

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
