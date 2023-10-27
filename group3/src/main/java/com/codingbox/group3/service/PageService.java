package com.codingbox.group3.service;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.repository.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PageService {

  private final PageRepository pageRepository;

  public Member findUserByUserId(String userId) {
    return pageRepository.findUserByUserId(userId);
  }

  public Member findloginMemberById(Long logimMemberId) {
    return pageRepository.findloginMemberById(logimMemberId);
  }
}
