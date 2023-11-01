package com.codingbox.group3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingbox.group3.dto.StoreForm;

@Controller
public class Controllerapi {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/{storeid}")
	public String Store(@PathVariable String storeid, @RequestParam String storeName, @RequestParam String storeAddr,
			@RequestParam String storeTel, Model model) {
		StoreForm storeForm = new StoreForm();
		storeForm.setStoreName(storeName);
		storeForm.setStoreAddr(storeAddr);
		storeForm.setStorePhone(storeTel);
		System.out.println("가게전화번호 " + storeForm.getStorePhone());
		model.addAttribute("store", storeForm);
		switch (storeid) {
		case "16":
			return "storedetail16";
		case "17":
			return "storedetail17";
		case "18":
			return "storedetail18";
		case "19":
			return "storedetail19";
		case "20":
			return "storedetail20";
		case "21":
			return "storedetail21";
		case "22":
			return "storedetail22";
		case "23":
			return "storedetail23";
		case "24":
			return "storedetail24";
		case "25":
			return "storedetail25";
		case "26":
			return "storedetail26";
		default:
			return "storedetail";
		}
	}

	@PostMapping("/storeList")
	public String search(@RequestParam("searchbox") String searchbox, Model model) {
		model.addAttribute("searchbox", searchbox);
		System.out.println(searchbox);
		return "storeList";
	}

}
