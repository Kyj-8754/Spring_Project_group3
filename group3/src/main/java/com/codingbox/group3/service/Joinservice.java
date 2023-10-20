package com.codingbox.group3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
@Transactional(readOnly = true)
public class Joinservice {

	private final MemberRepository userRepository;
	
	@Transactional
	public Long saveMember(Member member) {
		userRepository.save(member);
		return member.getId();
	}
	

}
