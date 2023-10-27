package com.codingbox.group3.controller;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.dto.MemberForm;
import com.codingbox.group3.service.Joinservice;
import com.codingbox.group3.service.PageService;
import jakarta.servlet.http.HttpSession;
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
  private final PageService pageService;

  @GetMapping("reservation_list")
  public String ReservationList(Model model) {
    model.addAttribute("form", new MemberForm());

    return "reservation_list";
  }

  @GetMapping("/revise")
  public String reviseForm(Model model, HttpSession session) {

    Member userid = (Member) session.getAttribute("loginMember");

    Long logimMemberId = userid.getId();
    Member memberForm = pageService.findloginMemberById(logimMemberId);
    model.addAttribute("userform", memberForm);

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
    member.setReg_date(LocalDateTime.now()); // 수정일자?

    joinservice.saveMember(member);
    return "redirect:/";
  }

  @GetMapping("/reviewpage")
  public String ReviewList(Model model) {

    return "reviewpage";
  }

  @GetMapping("mypage")
  public String logimMember(HttpSession session, Model model) {

    Member userid = (Member) session.getAttribute("loginMember");

    Long logimMemberId = userid.getId();
    Member loginMember = pageService.findloginMemberById(logimMemberId);
    System.out.println(loginMember.toString());
    model.addAttribute("loginMember", loginMember);
    return "mypage";
  }
}
