package com.codingbox.group3.repository;

import com.codingbox.group3.em.ReservationStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReservationSearch {
	// 회원 Name
	private String memberName;
	
	// 주문상태
	private ReservationStatus reservationStatus; 
}
