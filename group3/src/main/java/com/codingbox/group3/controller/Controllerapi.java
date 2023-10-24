package com.codingbox.group3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingbox.group3.dto.StoreForm;

@Controller
public class Controllerapi {
	

	@GetMapping("/")
	public String test(){return "storeList";}
	
	@GetMapping("/store/{storeid}")
	public String Store(@PathVariable String storeid,@RequestParam String storeName, @RequestParam String storeAddr,
			@RequestParam String storeTel, Model model) {
		StoreForm storeForm = new StoreForm();
		storeForm.setStoreName(storeName);
		storeForm.setStoreAddr(storeAddr);
		storeForm.setStorePhone(storeTel);
		System.out.println("가게전화번호 "+storeForm.getStorePhone());
		model.addAttribute("store",storeForm);
		return "storedetail";
	}
//	@GetMapping("/store")
//	public String test1() {
//		return "storedetail";
//	}
	
	@GetMapping("/store")
	public String test2(@RequestParam("addrsearch") String address, Model model) {
		model.addAttribute("address",address);
		return "storedetail";
	}
}
