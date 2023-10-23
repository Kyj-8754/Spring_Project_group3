package com.codingbox.group3.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

  @NotEmpty(message = "회원 아이디는 필수 입니다.") // memberId가 비어있으면 안된다는 어노테이션
  private String memberId;

  @NotEmpty(message = "비밀번호는 필수 입니다.") // memberPw가 비어있으면 안된다는 어노테이션
  private String memberPw;
}
