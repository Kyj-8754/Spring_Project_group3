package com.codingbox.group3.dto;

import com.codingbox.group3.domain.Member;
import com.codingbox.group3.domain.Store;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReservationForm {
	private Long id;
	private String day;
	private int count;
	private Member member;
	private Store store;
	private String time;
}
