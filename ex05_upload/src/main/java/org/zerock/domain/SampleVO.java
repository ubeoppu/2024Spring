package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SampleVO {

	private Integer mno;
	private String firstName;
	private String lastName;
}
