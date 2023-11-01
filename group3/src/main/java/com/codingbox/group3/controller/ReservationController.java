package com.codingbox.group3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.group3.domain.Booking;
import com.codingbox.group3.domain.Member;
import com.codingbox.group3.dto.ReservationForm;
import com.codingbox.group3.em.ReservationStatus;
import com.codingbox.group3.em.Time;
import com.codingbox.group3.service.ReservationService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReservationController {
   private final ReservationService reservationService;

//   // 홈페이지 로드시 생성되는 양식
//   @GetMapping("/store/view/{storeId}")
//   public String reservationForm(@PathVariable Long storeId, Model model)  {
//      System.out.println("예약컨트롤러 진입1");
//      Store store = storeService.findById(storeId);
//      model.addAttribute("store", store);
      
//      return "reservation";
//   }
   @ModelAttribute("reservationForm")
   public ReservationForm reservationForm() {
       return new ReservationForm();
   }
   
   // 해당 홈페이지에서 DB 넘기는양식
   @PostMapping("/store/view/reservation")
   public String writeReservation(@Valid ReservationForm form, BindingResult result, HttpSession session) {
	   
	   if(result.hasErrors()) {
         return "reservation";
      }
      Member loginMember = (Member) session.getAttribute("loginMember");
      if (loginMember != null) {
         Booking booking = new Booking();
         booking.setDay(String.valueOf(form.getDay()));
         booking.setYear(String.valueOf(form.getYear()));
         booking.setMonth(String.valueOf(form.getMonth()));
         booking.setCount(String.valueOf(form.getCount()));
         booking.setMember(loginMember);
         booking.setStatus(ReservationStatus.COMPLETE);
         booking.setStore_name(form.getStore_name());
         booking.setAddr(form.getAddr());
         booking.setTime(Time.valueOf(form.getTime()));
          booking.setStore_Phone(form.getStore_phone());
          
        System.out.println("loginMember:" + loginMember);
          System.out.println("booking2131564564895615123:" + form);
          System.out.println("booking2131564564895615123:" + booking);
      
          // 예약을 저장하기 위해 서비스를 호출하는 예시
          reservationService.saveWrite(booking);
      
          return "redirect:/mypage"; // 적절한 경로로 변경해야 합니다.
        } else {
           return "redirect:/login";
        }
   }
    
}


   