package com.codingbox.group3.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
@Transactional(readOnly = true)
public class Loginservice {

	private final LoginRepository loginRepository;
	
	public List<Member> login(String memberid) {
		return loginRepository.find(memberid);
	}

}
