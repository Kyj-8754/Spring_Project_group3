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
    if (userid != null) {
      Long logimMemberId = userid.getId();
      Member loginMember = pageService.findloginMemberById(logimMemberId);
      System.out.println(loginMember.toString());
      model.addAttribute("loginMember", loginMember);
      // 로그인 상태이면 마이페이지로 이동
      // 여기에서 회원 목록을 추가하거나 필요한 작업을 수행하세요
      return "mypage";
    } else {
      // 로그인 상태가 아니라면 로그인 페이지로 리디렉션
      return "redirect:/login"; // 로그인 페이지 URL로 변경
    }
  }
  // 로그인 세션이 없을 경우 마이페이지가 아닌 로그인 페이지로 이동
  //  @GetMapping("mypage")
  //  public String my(Model model, HttpSession session) {
  //    // 세션에서 로그인 상태 확인
  //
  //    Object loginMember = session.getAttribute("loginMember");
  //    String userId = (String) session.getAttribute("userId");
  //
  //    System.out.println("loginMember : " + loginMember);
  //    System.out.println("userId : " + userId);
  //    System.out.println("session : " + session);
  //    if (loginMember != null) {
  //      // 로그인 상태이면 마이페이지로 이동
  //      // 여기에서 회원 목록을 추가하거나 필요한 작업을 수행하세요
  //      return "mypage";
  //    } else {
  //      // 로그인 상태가 아니라면 로그인 페이지로 리디렉션
  //      return "redirect:/login"; // 로그인 페이지 URL로 변경
  //    }
  //  }
}
