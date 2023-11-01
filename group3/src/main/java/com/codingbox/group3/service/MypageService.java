package com.codingbox.group3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingbox.group3.domain.Booking;
import com.codingbox.group3.repository.MypageRepository;
import com.codingbox.group3.repository.PageRepository;
import com.codingbox.group3.repository.ReservationSearch;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MypageService {
	
	private final MypageRepository mypageRepository;

	public List<Booking> findOrders(ReservationSearch reservationSearch) {
		return mypageRepository.findAll(reservationSearch);
	}

	@Transactional
	public  void cancelReservation(Long bookingId) {
		Booking booking = mypageRepository.findOne(bookingId);
		
		booking.cancel();
	}

	
	

}
