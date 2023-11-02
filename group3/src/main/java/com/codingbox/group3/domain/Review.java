package com.codingbox.group3.domain;

import java.time.LocalDateTime;

import com.codingbox.group3.em.Score;

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
public class Review {

	@Override
	public String toString() {
		return "Review [score=" + score + "]";
	}

	@Id @GeneratedValue
	@Column(name = "REVIEW_ID")
	private Long id;
	private String info;
	private LocalDateTime reviewDate;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;
	
	
	@Enumerated(EnumType.STRING)
	private Score score;
}
