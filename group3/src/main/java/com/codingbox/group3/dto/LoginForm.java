package com.codingbox.group3.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginForm {

//	@NotEmpty(message = "회원 이름은 필수 입니다.") // name이 비어있으면 안된다는 어노테이션
	private String memberId;
	private String memberPw;
	
}
