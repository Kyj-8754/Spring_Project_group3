package com.codingbox.group3.controller;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.dto.LoginForm;
import com.codingbox.group3.dto.MemberForm;
import com.codingbox.group3.service.Joinservice;
import com.codingbox.group3.service.Loginservice;
import com.codingbox.group3.session.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LogjoinController {

  private final Loginservice loginservice;
  private final Joinservice joinservice;

  //  @GetMapping("login")
  //  public String Login(Model model) {
  //    model.addAttribute("loginform", new LoginForm());
  //    return "LoginForm";
  //  }
  @GetMapping("login")
  public String Login(@ModelAttribute("loginform") LoginForm form) {

    return "LoginForm";
  }

  @PostMapping("login")
  public String loginV3(
      @ModelAttribute("loginForm") LoginForm form,
      Model model,
      RedirectAttributes redirectAttrs,
      HttpServletRequest request,
      @RequestParam(defaultValue = "/") String redirectURL) {

    HttpSession session = request.getSession(); // 세션 생성
    Member loginMember = loginservice.login(form.getMemberId(), form.getMemberPw(), session);
    System.out.println("loginMember : " + loginMember);
    if (loginMember == null) {
      // 로그인 실패
      model.addAttribute("msg", "로그인 실패");
      return "LoginForm";
    } else {
      // 로그인 성공
      // 세션에 로그인 회원 정보 보관
      session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

      redirectAttrs.addFlashAttribute("msg", "로그인 성공");
      System.out.println(session.toString());
      return "redirect:" + redirectURL;
    }
  }

  @GetMapping("join")
  public String joinForm(Model model) {
    model.addAttribute("userform", new MemberForm());
    return "joinForm";
  }

  @PostMapping("join")
  public String addjoin(
      @ModelAttribute("userform") @Valid MemberForm userform, BindingResult result, Model model) {

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
    model.addAttribute("loginform", new LoginForm());
    return "LoginForm";
  }

  @ResponseBody
  public String checkId(@RequestParam String userId) {
    boolean isIdAvailable = isUserIdAvailable(userId);
    if (isIdAvailable) {
      return "available";
    } else {
      return "exists";
    }
  }

  @PostMapping("logout")
  public String logoutV2(HttpServletRequest request) {
    // 세션을 삭제
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }
    return "redirect:/";
  }

  private boolean isUserIdAvailable(String userId) {
    Member existingMember = joinservice.findMemberByUserId(userId);
    return existingMember == null;
  }
}
