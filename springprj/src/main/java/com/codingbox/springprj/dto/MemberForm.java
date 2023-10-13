package com.codingbox.springprj.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

	@NotEmpty(message = "회원 이름은 필수 입니다.") // name이 비어있으면 안된다는 어노테이션
	private String name;
	private String city;
	private String street;
	private String zipcode;
	
}
