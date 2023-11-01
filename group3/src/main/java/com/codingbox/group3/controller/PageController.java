package com.codingbox.group3.controller;

import com.codingbox.group3.domain.Booking;
import com.codingbox.group3.domain.Member;
import com.codingbox.group3.dto.MemberForm;
import com.codingbox.group3.repository.ReservationSearch;
import com.codingbox.group3.service.Joinservice;
import com.codingbox.group3.service.MypageService;
import com.codingbox.group3.service.PageService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PageController {
  private final Joinservice joinservice;
  private final PageService pageService;
  private final MypageService mypageService;



  @GetMapping("/revise")
  public String reviseForm(Model model, HttpSession session) {

      Member userid = (Member) session.getAttribute("loginMember");

      Long logimMemberId = userid.getId();
      Member memberForm = pageService.findloginMemberById(logimMemberId);
      model.addAttribute("userform", memberForm);

      return "revise";
  }

  @PostMapping("revise")
  public String revise(Model model,Member userform, HttpSession session) {
      model.addAttribute("userform",userform);
      Member userid = (Member) session.getAttribute("loginMember");

      Long logimMemberId = userid.getId();
      Member member = pageService.findloginMemberById(logimMemberId);


      member.setUserPw(userform.getUserPw());
      member.setBirth(userform.getBirth());
      member.setPhone(userform.getPhone());
      member.setEmail(userform.getEmail());

      Long loginMemberId = joinservice.saveMember(member);
      Member loginMember = pageService.findloginMemberById(loginMemberId);
      model.addAttribute("loginMember", loginMember);
      return "mypage";
  }

  
  @GetMapping("/reviewpage")
  public String ReviewList(Model model) {

    return "reviewpage";
  }

  @GetMapping("mypage")
  public String logimMember(HttpSession session, @ModelAttribute("reservationSearch")ReservationSearch reservationSearch, Model model) {

      Member form = (Member) session.getAttribute("loginMember");
      if (form != null) {
          Long logimMemberId = form.getId();
          Member loginMember = pageService.findloginMemberById(logimMemberId);
          System.out.println(loginMember.toString());
          model.addAttribute("loginMember", loginMember);
          
          List<Booking> bookings = mypageService.findOrders(reservationSearch);
          model.addAttribute("bookings", bookings);
          return "mypage";
      } else {
          return "redirect:/login";
      }// 로그인 페이지 URL로 변경
      }
      public String reservationList(@ModelAttribute("reservationSearch")ReservationSearch reservationSearch,
  			Model model) {
  List<Booking> bookings = mypageService.findOrders(reservationSearch);
  model.addAttribute("bookings", bookings);

  return "reservation_list";
  }
   @GetMapping("reservation_list")
   public String listReservation(@ModelAttribute("reservationSearch")ReservationSearch reservationSearch,
  			Model model) {
  	model.addAttribute("form", new MemberForm());
   List<Booking> bookings = mypageService.findOrders(reservationSearch);
   model.addAttribute("bookings", bookings);

   return "reservation_list";
   }
   @PostMapping("/reservation_list/{bookingId}/cancel")
   public String cancelReservation(@PathVariable("bookingId") Long bookingId) {
       mypageService.cancelReservation(bookingId);
       return "redirect:/mypage";
   }
}