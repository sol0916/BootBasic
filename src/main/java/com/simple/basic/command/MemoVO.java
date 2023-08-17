package com.simple.basic.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemoVO {
	
	private int mno;
	@NotBlank(message = "메모는 필수 입력입니다")
	private String memo;
	@Pattern(message = "000-0000-0000 형식을 지켜주십시오", regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}")
	private String phone;
	@Pattern(message = "비밀번호는 숫자로 4자리입니다", regexp = "[0-9]{4}")
	private String pw;
	private String secret;

}
