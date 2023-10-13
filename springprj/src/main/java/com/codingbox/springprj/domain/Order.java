package com.codingbox.springprj.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "orders")
@Getter @Setter
public class Order {

	@Id @GeneratedValue
	@Column(name="ORDER_ID")
	private Long id;
	@Column(name="ORDER_DATE")
	private LocalDateTime orderDate;

	// 주문 상태(ORDER, CANCEL)
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Member member;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItem
		= new ArrayList<>();
	
	//연관 관계 메서드
	// setMember
	// addOrderItem
	
	private void setMember(Member member) {
		this.member = member;
		member.getOrder().add(this);
	}
	
	private void addOrderItem(OrderItem orderItem) {
		this.orderItem.add(orderItem);
		orderItem.setOrder(this);
	}
}
