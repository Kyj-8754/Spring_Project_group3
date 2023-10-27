package com.codingbox.group3.repository;


import org.springframework.stereotype.Repository;

import com.codingbox.group3.domain.Store;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreRepository {
	private final EntityManager em;
	
	public void saveStore(Store store) {
		em.persist(store);
	}
	public Store findById(Long id) {
		return em.find(Store.class, id);
	}
	public Store findone(Long storeId) {
		return em.find(Store.class, storeId);
	}

}
