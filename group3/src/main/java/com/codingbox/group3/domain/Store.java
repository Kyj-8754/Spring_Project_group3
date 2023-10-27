package com.codingbox.group3.domain;

import java.util.ArrayList;
import java.util.List;

import com.codingbox.group3.em.Parking;
import com.codingbox.group3.em.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Store {

	@Id @GeneratedValue
	@Column(name = "STORE_ID")
	private Long id;
	
	private String keyword;
	private String storeName;
	private String storeAddr;
	private String storeTel;
	
	@OneToMany(mappedBy = "store")
	private List<Review> review = new ArrayList<>();
	
	@OneToMany(mappedBy = "store")
	private List<Menu> menu = new ArrayList<>();
	
	@OneToMany(mappedBy = "store")
	private List<Booking> booking = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private Parking parking;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "START_TIME")
	private Time start_time;

	@Enumerated(EnumType.STRING)
	@Column(name = "END_TIME")
	private Time end_time;

}