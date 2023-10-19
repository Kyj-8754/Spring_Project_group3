package com.codingbox.group3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controllerapi {

	@GetMapping("/")
	public String test(){return "test";}
	
	@GetMapping("/store")
	public String test1() {
		return "storedetail";
	}
	
	
	
	
}
