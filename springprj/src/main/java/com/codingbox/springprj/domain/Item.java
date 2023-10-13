package com.codingbox.springprj.domain;

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
public class Item {

	@Id @GeneratedValue
	@Column(name="ITEM_ID")
	private Long id;
	private String name;
	private int price;
	@Column(name="STOCK_QUANTITY")
	private int stockQuantity;
	
	@OneToMany(mappedBy = "item")
	private List<OrderItem> OrderItem
		= new ArrayList<>();
	
}
