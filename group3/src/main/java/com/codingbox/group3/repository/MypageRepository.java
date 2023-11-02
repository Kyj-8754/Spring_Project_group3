package com.codingbox.group3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.codingbox.group3.domain.Booking;
import com.codingbox.group3.domain.QBooking;
import com.codingbox.group3.domain.QMember;
import com.codingbox.group3.em.ReservationStatus;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MypageRepository {
	private final EntityManager em;

	public List<Booking> findAll(ReservationSearch reservationSearch) {
		JPAQueryFactory factory = new JPAQueryFactory(em);

		QBooking booking = QBooking.booking;
		QMember member = QMember.member;

		return factory.select(booking).from(booking).join(booking.member, member)
				.where(statEq(reservationSearch.getReservationStatus()), nameLike(reservationSearch.getMemberName()))
				.fetch();
	}

	private BooleanExpression statEq(ReservationStatus reservationStatus) {
		if (reservationStatus == null) {
			return null;
		}
		return QBooking.booking.status.eq(reservationStatus);
	}

	private BooleanExpression nameLike(String memberName) {
		if (memberName == null || memberName.equals("")) {
			return null;
		}
		return QMember.member.name.contains(memberName);
	}

	public Booking findOne(Long bookingId) {
		System.out.println("여기닷");
		System.out.println("bookingId : " + bookingId);
		return em.find(Booking.class, bookingId);
	}
}
