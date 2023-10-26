package com.codingbox.group3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codingbox.group3.domain.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	@Autowired
	private final EntityManager em;
	
	public void save(Member member) {
		em.persist(member);
	}
	public Member findMemberByUserId(String userId) {
	    TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.userId = :userId", Member.class);
	    query.setParameter("userId", userId);
	    List<Member> resultList = query.getResultList();
	    return resultList.isEmpty() ? null : resultList.get(0);
	}
	}


