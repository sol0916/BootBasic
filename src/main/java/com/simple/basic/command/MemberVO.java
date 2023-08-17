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
public class MemberVO {
	
	@NotBlank(message = "아이디는 필수입니다")
	@Pattern(message = "아이디는 영문,숫자를 사용하여 8자 이상이어야 합니다", regexp = "[a-zA-Z0-9]{8,}")
	private String id;

	@NotBlank(message = "비밀번호는 필수입니다")
	@Pattern(message = "비밀번호는 영문, 숫자, 특수문자를 사용하여 8자 이상이어야 합니다", regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$")
	private String pw;

}
