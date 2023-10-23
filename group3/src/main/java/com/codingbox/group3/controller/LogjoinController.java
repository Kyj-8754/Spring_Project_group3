package com.codingbox.group3.controller;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.dto.LoginForm;
import com.codingbox.group3.dto.MemberForm;
import com.codingbox.group3.service.Joinservice;
import com.codingbox.group3.service.Loginservice;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LogjoinController {

  private final Loginservice loginservice;
  private final Joinservice joinservice;

  @GetMapping("login")
  public String Login(Model model) {
    model.addAttribute("loginform", new LoginForm());
    return "LoginForm";
  }

  @PostMapping("login")
  public String Login(@RequestParam String userId, @RequestParam String userPw) {
    List<Member> memberlist = loginservice.login(userId);
    String result = "redirect:login";
    for (Member member : memberlist) {
      if (member.getUserPw().equals(userPw)) {
        System.out.println("비밀번호 확인 성공");
        result = "redirect:/";
      } else {
        result = "redirect:login";
      }
    }
    return result;
  }

  @GetMapping("join")
  public String joinForm(Model model) {
    model.addAttribute("userform", new MemberForm());
    return "joinForm";
  }

  @PostMapping("join")
  public String addjoin(
      @ModelAttribute("userform") @Valid MemberForm userform, BindingResult result) {

    if (result.hasErrors()) {
      return "joinForm";
    }
    Member member = new Member();
    member.setUserId(userform.getUserId());
    member.setUserPw(userform.getUserPw());
    member.setName(userform.getName());
    member.setBirth(userform.getBirth());
    member.setGender(userform.getGender());
    member.setPhone(userform.getPhone());
    member.setEmail(userform.getEmail());
    member.setReg_date(LocalDateTime.now());

    joinservice.saveMember(member);
    return "redirect:/";
  }
}
