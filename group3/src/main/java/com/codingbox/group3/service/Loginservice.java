package com.codingbox.group3.service;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.repository.LoginRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Loginservice {

  private final LoginRepository loginRepository;

  public Member login(String memberId, String memberPw, HttpSession session) {
    Member member = loginRepository.find(memberId, session);
    System.out.println("member : " + member);
    if (member != null && member.getUserPw().equals(memberPw)) {
      return member;
    } else {
      return null;
    }
  }
}
