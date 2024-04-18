package kr.com.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*BNO        NOT NULL NUMBER(10)     
TITLE      NOT NULL VARCHAR2(200)  
CONTENT    NOT NULL VARCHAR2(2000) 
WRITER     NOT NULL VARCHAR2(100)  
REGDATE             DATE           
UPDATEDATE          DATE           
*/

@AllArgsConstructor
@Data
@Builder

public class BoardVO {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;

}
