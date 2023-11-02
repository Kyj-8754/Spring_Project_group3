package com.codingbox.group3.service;

import org.springframework.stereotype.Service;

import com.codingbox.group3.domain.Booking;
import com.codingbox.group3.repository.ReservationRepository;

import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {
	private final ReservationRepository reRepository;
	
	@Transactional
	public Long saveWrite(Booking booking) {
	    reRepository.saveWrite(booking); // Booking 객체를 데이터베이스에 저장
	    return booking.getId();
	}
	
	@Transactional
	public Booking findById(Long reservationid) {
		
		return reRepository.findById(reservationid);
	}
	
	
	

}
