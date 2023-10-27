package com.codingbox.group3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.group3.domain.Booking;
import com.codingbox.group3.domain.Member;
import com.codingbox.group3.domain.Store;
import com.codingbox.group3.dto.ReservationForm;
import com.codingbox.group3.em.Time;
import com.codingbox.group3.service.ReservationService;
import com.codingbox.group3.service.StoreService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReservationController {
	private final ReservationService reservationService;
	private final StoreService storeService;

	@GetMapping("/store/view/{storeId}/reservation")
	public String reservationForm(@PathVariable Long storeId, Model model) {
		Store store = storeService.findById(storeId);
		model.addAttribute("store", store);
		
		return "reservation";
	}
	
	
	@PostMapping("/store/view/{storeId}/reservation")
    public String writeReservation(@PathVariable Long storeId,@Valid ReservationForm form, BindingResult result, HttpSession session) {
        if(result.hasErrors()) {
            return "reservation";
        }
        Member loginMember = (Member) session.getAttribute("loginMember");
		if(loginMember != null) {
		    Booking booking = new Booking();
		    booking.setDay(form.getDay()); // 예약 날짜
		    booking.setCount(form.getCount()); // 인원 수
		    booking.setStoreid(storeId); // 가게 정보
		    booking.setTime(Time.valueOf(form.getTime())); // 시간
		    booking.setMember(loginMember);
		    
		    System.out.println("loginMember:" + loginMember);
		    // 예약을 저장하기 위해 서비스를 호출하는 예시
		    reservationService.saveWrite(booking);
		
		    return "redirect:/reservation-confirmation"; // 적절한 경로로 변경해야 합니다.
        } else {
        	return "redirect:/LoginForm";
        }
	}
	 
}


	
