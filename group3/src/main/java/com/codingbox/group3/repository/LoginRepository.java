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
public class LoginRepository {

	@Autowired
	private final EntityManager em;
	
	public List<Member> find(String memberId) {
		
		TypedQuery<Member> result = em.createQuery("SELECT m FROM Member m WHERE m.userId = :memberId", Member.class);
		result.setParameter("memberId", memberId);
	    return result.getResultList();
	}

}
