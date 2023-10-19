package com.codingbox.group3.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codingbox.group3.domain.Member;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	@Autowired
	private final EntityManager em;
	
	public void save(Member member) {
		em.persist(member);
	}
}
