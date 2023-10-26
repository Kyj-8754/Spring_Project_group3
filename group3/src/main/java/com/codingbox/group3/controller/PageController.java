package com.codingbox.group3.controller;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.dto.MemberForm;
import com.codingbox.group3.service.Joinservice;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PageController {
  private final Joinservice joinservice;

  @GetMapping("reservation_list")
  public String ReservationList(Model model) {
    model.addAttribute("form", new MemberForm());

    return "reservation_list";
  }

  @GetMapping("/revise")
  public String Revise(Model model) {

    return "revise";
  }

  @PostMapping("revise")
  public String revise(@Valid MemberForm form, BindingResult result) {
    Member member = new Member();
    member.setUserId(form.getUserId());
    member.setUserPw(form.getUserPw());
    member.setName(form.getName());
    member.setBirth(form.getBirth());
    member.setGender(form.getGender());
    member.setPhone(form.getPhone());
    member.setEmail(form.getEmail());
    member.setReg_date(LocalDateTime.now());

    joinservice.saveMember(member);
    return "redirect:/";
  }

  @GetMapping("/reviewpage")
  public String ReviewList(Model model) {

    return "reviewpage";
  }

  @GetMapping("mypage")
  public String mypage(Model model) {

    return "mypage";
  }
}
