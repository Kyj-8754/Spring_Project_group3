package com.codingbox.group3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.repository.PageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PageService {

    private final PageRepository pageRepository;

    public Member findUserByUserId(String userId) {
        return pageRepository.findUserByUserId(userId);
    }
}