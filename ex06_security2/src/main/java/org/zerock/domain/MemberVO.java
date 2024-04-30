package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*userid varchar2(50) not null primary key,
userpw varchar2(100) not null,
username varchar2(100) not null,
regdate date default sysdate, 
updatedate date default sysdate,
enabled char(1) default '1');*/

@Data
public class MemberVO {
	
	private String userid;
	private String userpw;
	private String username;
	private Date regdate;
	private Date updatedate;
	private boolean enabled;
	private List<AuthVO>authList;

}
