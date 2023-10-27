package com.codingbox.group3.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Revise {

	@Id
	@GeneratedValue
	
	private Long id;
    private String userId;
    private String userPw;
}
