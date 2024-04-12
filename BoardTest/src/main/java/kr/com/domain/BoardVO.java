package kr.com.domain;

//CREATE TABLE BOARD(
//bno number(10) not null primary key,
//Name varchar2(12) not null,
//Title varchar2(30) not null,
//Content varchar2(1000) not null,
//regDate date default sysdate,
//updateDate date default sysdate
//);

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@AllArgsConstructor
public class BoardVO {
	
	public BoardVO(){
		
	}
	
	private int bno;
	private String name;
	private String title;
	private String content;
	private Date regDate;
	private Date updateDate;

	
}
