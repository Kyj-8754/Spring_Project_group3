package com.codingbox.springprj.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemForm {

	private Long id;
	
	//@NotEmpty(message = "상품명은 필수 입니다.")
	private String name;
	//@NotEmpty(message = "상품 가격을 입력해주세요.")
	private int item_pirce;
	//@NotEmpty(message = "상품 수량을 입력해주세요.")
	private int item_quantity;
	
}
