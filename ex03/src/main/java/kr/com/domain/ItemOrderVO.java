package kr.com.domain;
//CREATE TABLE ITEMORDER(
//ONO NUMBER(20) NOT NULL PRIMARY KEY,
//USERID VARCHAR(30) NOT NULL,
//INO NUMBER(20) NOT NULL,
//QUANTITY NUMBER(20) NOT NULL
//);

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ItemOrderVO {
	
	private int ono;
	private String userId;
	private int ino;
	private int quantity;

}
