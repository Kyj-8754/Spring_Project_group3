package com.codingbox.group3.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	private String userId;
	private String userPw;
	private String name;
	private String phone;
	private String email;
	private String birth;
	private String gender;
	private LocalDateTime reg_date;
	
	@OneToMany(mappedBy = "member")
	private List<Review> review = new ArrayList<>();
	
	@OneToMany(mappedBy = "member")
	private List<Booking> booking = new ArrayList<>();
}
