package com.codingbox.group3.repository;

import com.codingbox.group3.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LoginRepository {

  @Autowired private final EntityManager em;

  private static Map<Long, Member> store = new HashMap<>();

  public Member find(String memberId, HttpSession session) {
    TypedQuery<Member> query =
        em.createQuery("SELECT m FROM Member m WHERE m.userId = :memberId", Member.class);
    System.out.println("memberId : " + memberId);
    query.setParameter("memberId", memberId);
    List<Member> results = query.getResultList();

    if (!results.isEmpty()) {
      Member loginMember = results.get(0); // 첫 번째 결과 사용
      session.setAttribute("loginMember", loginMember);
      return loginMember;
    } else {
      return null;
    }
  }

  public boolean isUserIdAvailable(String userId) {
    TypedQuery<Long> query =
        em.createQuery("SELECT COUNT(m) FROM Member m WHERE m.userId = :userId", Long.class);
    query.setParameter("userId", userId);
    Long count = query.getSingleResult();
    return count == 0;
  }
}
