package com.codingbox.springprj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.springprj.domain.Address;
import com.codingbox.springprj.domain.Member;
import com.codingbox.springprj.dto.MemberForm;
import com.codingbox.springprj.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller @RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	 
	// url : /members/new
	// model : memberForm에 있는 변수에 담아 members/createMemberForm.html으로 전달
	@GetMapping("members/new")
	public String createform(Model model) {
		model.addAttribute("memberForm", new MemberForm());
		return "members/createMemberForm";
	}
	/*
	 * @Valid 다음에 BindingREesult가 있으면, error를 Binding에 담아준다.
	 */
	// 회원가입
	@PostMapping("members/new")
	public String addform(@Valid MemberForm form, BindingResult result) throws IllegalAccessException{
		if(result.hasErrors()) {
			return "members/createMemberForm";
		}
		
		Address address = new Address(form.getCity(),form.getStreet(),form.getZipcode());
		Member member = new Member();
		member.setName(form.getName());
		member.setAddress(address);
		
		memberService.join(member);
		return "redirect:/"; 
	}
	
	@GetMapping("members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members",members);
		return "members/memberList";
	}
	
}
