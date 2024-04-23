package kr.com.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
/*
CREATE TABLE member(
id	varchar2(50) not null primary key,
pwd	varchar2(50) not null,
email	varchar2(50) not null,	
name	varchar2(50) not null,
phone	varchar2(50) not null,
address varchar2(50),
zipCode number(5),
detailAddress varchar2(50),
extraAddress varchar2(50),
gender	varchar2(50) not null,
birth	date not null,
regdate	date default sysdate,
verify	number(5)default 0
);*/

@AllArgsConstructor
@Builder
@Data
public class MemberVO {
	
	private String id;
	private String pwd;
	private String email;
	private String name;
	private String phone;
	private String address;
	private int zipCode;
	private String detailAddress;
	private String extraAddress;
	private String gender;
	private String birth;
	private Date regdate;
	private Long verify;

}
