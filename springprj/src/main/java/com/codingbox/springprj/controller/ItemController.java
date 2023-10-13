package com.codingbox.springprj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.springprj.domain.Item;
import com.codingbox.springprj.dto.ItemForm;
import com.codingbox.springprj.service.ItemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;
	
	
	@GetMapping("/items/new")
	public String createForm(Model model) {
		model.addAttribute("itemform",new ItemForm());
		return "items/createItemForm";
	}
	
	@PostMapping("/items/new")
	public String addItem(@Valid ItemForm form, BindingResult result) {
//		if(result.hasErrors()) {
//			return "members/createMemberForm";
//		}
		Item item = new Item();
		item.setName(form.getName());
		item.setPrice(form.getItem_pirce());
		item.setStockQuantity(form.getItem_quantity());
		
		
		itemService.saveItem(item);
		return "redirect:/";
	}
	
	@GetMapping("/items")
	public String list(Model model) {
		List<Item> items = itemService.findItems();
		model.addAttribute("items",items);
		return "items/itemList";
	}
}
