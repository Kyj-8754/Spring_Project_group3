package com.codingbox.group3.domain;

import com.codingbox.group3.em.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Booking {

	@Id @GeneratedValue
	@Column(name = "BOOKING_ID")
	private Long id;
	private String day;
	private int count;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "STORE_ID")
	private Store store;
	
	@Enumerated(EnumType.STRING)
	private Time time;
}
