package com.codingbox.springprj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.springprj.domain.Item;
import com.codingbox.springprj.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
	private final ItemRepository itemRepository;

	@Transactional
	public Long saveItem(Item item) {
		itemRepository.save(item);
		return item.getId();
	}

	public List<Item> findItems() {
		
		return itemRepository.findAll();
	}

}
