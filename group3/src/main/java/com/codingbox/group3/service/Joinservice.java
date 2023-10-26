package com.codingbox.group3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Joinservice {

  private final MemberRepository memberRepository;

  @Transactional
  public Long saveMember(Member member) {
    memberRepository.save(member);
    return member.getId();
  }

  public boolean isUserIdAvailable(String userId) {
    Member existingMember = memberRepository.findMemberByUserId(userId);
    return existingMember == null;
  }

  public Member findMemberByUserId(String userId) {
    return memberRepository.findMemberByUserId(userId);
  }
}
