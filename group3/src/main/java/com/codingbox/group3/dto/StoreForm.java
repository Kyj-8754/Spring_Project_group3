package com.codingbox.group3.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StoreForm {
	
	private Long id;
	
	private String keyword;
	private String parking;
	private String end_time;
	private String start_time;
	private String menu;
	
	// 지도API에서 불러온 데이터 저장하는 곳
	private String storeName;
	private String storeAddr;
	private String storePhone;
	private String storeRoadAddr;
}
