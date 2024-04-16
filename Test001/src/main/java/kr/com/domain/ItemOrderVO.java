package kr.com.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*CREATE TABLE ITEMORDER(
ONO NUMBER(20) NOT NULL PRIMARY KEY,
USERID VARCHAR(30) NOT NULL,
INO NUMBER(20) NOT NULL,
QUANTITY NUMBER(20) NOT NULL
);*/
@Data
@AllArgsConstructor
@Builder
public class ItemOrderVO {
	
	private int ono;
	private String userId;
	private int ino;
	private int quantity;

}
