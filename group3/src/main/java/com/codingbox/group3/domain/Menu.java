package com.codingbox.group3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Menu {

	@Id @GeneratedValue
	@Column(name = "MENU_ID")
	private Long id;
	private String name;
	private int price;
	private String info;

}
