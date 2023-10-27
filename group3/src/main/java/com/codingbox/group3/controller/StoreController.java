package com.codingbox.group3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.group3.domain.Store;
import com.codingbox.group3.dto.MemberForm;
import com.codingbox.group3.dto.StoreForm;
import com.codingbox.group3.em.Parking;
import com.codingbox.group3.em.Time;
import com.codingbox.group3.service.StoreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/store/write")
    public String writeStoreForm(Model model) {
        model.addAttribute("storeDTO", new StoreForm());
        return "writeStore";
    }

    
    @PostMapping("/store/write")
    public String writeStore(@Valid StoreForm storeDTO, BindingResult result) {
        Store store = new Store();
        store.setKeyword(storeDTO.getKeyword());
        store.setParking(Parking.valueOf(storeDTO.getParking())); // Parking 열거형으로 변환
        store.setStart_time(Time.valueOf(storeDTO.getEnd_time())); // Time 열거형으로 변환
        store.setEnd_time(Time.valueOf(storeDTO.getStart_time())); // Time 열거형으로 변환
        

        storeService.saveStore(store);
        return "writeStore";
    }

    @GetMapping("/store/view/{storeid}")
    public String viewStore1(@PathVariable Long storeid, Model model) {
        Store store = storeService.findById(storeid);
        model.addAttribute("store", store);
        return "storedetail";
        
    }
   
    
}