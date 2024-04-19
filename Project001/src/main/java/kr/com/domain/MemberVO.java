package kr.com.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*CREATE TABLE member(
userID varchar(20) primary key,
userPW varchar(100) not null,
phone varchar(50) not null,
email varchar(50) not null,
address varchar(60) not null,
regdate datetime default now()
);*/

@Data
@Builder
@AllArgsConstructor
public class MemberVO {
	
	private String userID;
	private String userPW;
	private String phone;
	private String email;
	private String address;
	private Date regdate;

}
