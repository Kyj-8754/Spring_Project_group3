package com.codingbox.group3.repository;

import com.codingbox.group3.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PageRepository {

  @Autowired private final EntityManager em;

  public Member findUserByUserId(String userId) {
    return em.createQuery("SELECT m FROM Member m WHERE m.userId = :userId", Member.class)
        .setParameter("userId", userId)
        .getSingleResult();
  }

  public Member findloginMemberById(Long logimMemberId) {
    return em.createQuery("select m from  Member m where  m.id = :memberId", Member.class)
        .setParameter("memberId", logimMemberId)
        .getSingleResult();
  }

}
