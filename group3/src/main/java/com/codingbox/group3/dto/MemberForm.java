package com.codingbox.group3.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

	@NotEmpty(message = "회원 아이디는 필수입니다.") // userId가 비어있으면 안된다는 어노테이션
	@Pattern(regexp = "^[A-Za-z0-9_\\-]{5,20}$", message = "숫자와 영어로 5자리 이상 입력해주세요.")
	private String userId;

	@NotEmpty(message = "비밀번호는 필수입니다.") // userPw가 비어 있으면 안된다는 어노테이션
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z]).{6,16}", message = "숫자와 영어로 구성하여 6자리 이상 입력해주세요.")
	private String userPw;

	@NotEmpty(message = "회원 이름은 필수입니다.") // name이 비어 있으면 안된다는 어노테이션
	@Pattern(regexp = "^[가-힣]*$", message = "이름은 한글만 입력 가능합니다.")
	private String name;

	@NotEmpty(message = "휴대폰 번호는 필수입니다.")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호 양식과 맞지 않습니다.")
	private String phone;

	private String email;

	private String birth;

	private String gender;
}