package com.codingbox.group3.domain;

import com.codingbox.group3.em.ReservationStatus;
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
@Getter
@Setter
public class Booking {

	@Id
	@GeneratedValue
	@Column(name = "BOOKING_ID")
	private Long id;
	private String day;
	private String count;
	private String store_name;
	private String addr;
	private String year;
	private String month;
	private String store_Phone;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@Enumerated(EnumType.STRING)
	private Time time;

	@Enumerated(EnumType.STRING)
	private ReservationStatus status;

	public static Booking createReservation(Member member) {
		Booking booking = new Booking();
		booking.setMember(member);
		booking.setStatus(ReservationStatus.COMPLETE);
		return booking;
	}

	public void cancel() {
		this.setStatus(ReservationStatus.CANCEL);
	}


}