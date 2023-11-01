package com.codingbox.group3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

//@Controller
@RequiredArgsConstructor
public class MemberController {


	// 로그인 세션이 없을 경우 마이페이지가 아닌 로그인 페이지로 이동
	@GetMapping("mypage")
	public String my(Model model, HttpSession session) {
		// 세션에서 로그인 상태 확인

		Object loginMember = session.getAttribute("loginMember");
		String userId = (String) session.getAttribute("userId");

		System.out.println("loginMember : " + loginMember);
		System.out.println("userId : " + userId);
		System.out.println("session : " + session);
		if (loginMember != null) {
			// 로그인 상태이면 마이페이지로 이동
			// 여기에서 회원 목록을 추가하거나 필요한 작업을 수행하세요
			return "mypage";
		} else {
			// 로그인 상태가 아니라면 로그인 페이지로 리디렉션
			return "redirect:/login"; // 로그인 페이지 URL로 변경
		}
	}
}
