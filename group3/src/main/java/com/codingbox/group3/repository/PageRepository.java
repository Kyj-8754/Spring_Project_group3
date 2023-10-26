package com.codingbox.group3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codingbox.group3.domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class PageRepository {

  
    @Autowired	
    private final EntityManager em;

    public Member findUserByUserId(String userId) {
        return em.createQuery("SELECT m FROM Member m WHERE m.userId = :userId", Member.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }
}