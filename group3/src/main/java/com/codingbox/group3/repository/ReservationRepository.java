package com.codingbox.group3.repository;

import org.springframework.stereotype.Repository;

import com.codingbox.group3.domain.Booking;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {
	private final EntityManager em;
	
	public void saveWrite(Booking booking) {
		em.persist(booking);
	}

	public Booking findById(Long reservationid) {
		return em.find(Booking.class, reservationid);
	}

}
