package com.codingbox.group3;

import com.codingbox.group3.domain.Review;
import com.codingbox.group3.em.Score;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main01 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Review review = new Review();
		
		review.setScore(Score.FOUR);

		
		em.persist(review);
		
		System.out.println(review.toString());
		tx.commit();
		em.close();
		emf.close();
	}

}
