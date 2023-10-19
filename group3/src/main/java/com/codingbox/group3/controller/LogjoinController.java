package com.codingbox.group3.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.dto.MemberForm;
import com.codingbox.group3.service.Joinservice;
import com.codingbox.group3.service.Loginservice;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class LogjoinController {

	private final Loginservice loginsevice;
	private final Joinservice joinservice;
	
	@GetMapping("login")
	public String LoginForm(Model model) {
		model.addAttribute("loginform",new com.codingbox.group3.dto.LoginForm());
		return "LoginForm";
	}
	
	@PostMapping("login")
	public String Login(@Valid com.codingbox.group3.dto.LoginForm form, Model model) {
		loginsevice.
		
		model.addAttribute(memberId);
		return "redirect:/";
	}
	
	@GetMapping("join")
	public String joinForm(Model model) {
		model.addAttribute("userform",new MemberForm());
		return "joinForm";
	}
	
	
	@PostMapping("join")
	public String addjoin(@Valid MemberForm form, BindingResult result) {
		Member member = new Member();
		member.setMemberId(form.getMemberId());
		member.setMemberPw(form.getMemberPw());
		member.setName(form.getName());
		member.setBirth(form.getBirth());
		member.setGender(form.getGender());
		member.setPhone(form.getPhone());
		member.setEmail(form.getEmail());
		member.setReg_date(LocalDateTime.now());
		
		joinservice.saveMember(member);
		return "redirect:/";
	}
}
