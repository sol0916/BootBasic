package com.simple.basic.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleVO {
	
	private int sno;
	private String first; //이름
	private String last; //성
	private LocalDateTime regdate;

}
