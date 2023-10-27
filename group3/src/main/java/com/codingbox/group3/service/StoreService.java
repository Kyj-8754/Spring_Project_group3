package com.codingbox.group3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codingbox.group3.domain.Store;
import com.codingbox.group3.dto.StoreForm;
import com.codingbox.group3.em.Parking;
import com.codingbox.group3.em.Time;
import com.codingbox.group3.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public void saveStore(Store store) {
        storeRepository.saveStore(store);
    }

    @Transactional
    public Store findById(Long id) {
    	System.out.println("id : " + id);
        return storeRepository.findById(id);
    }

//    @Transactional
//    public void updateStore(Long storeId, StoreForm storeDTO) {
//        Store store = storeRepository.findone(storeId);
//        store.setKeyword(storeDTO.getKeyword());
//        store.setParking(Parking.valueOf(storeDTO.getParking())); // Parking 열거형으로 변환
//        store.setStart_time(Time.valueOf(storeDTO.getStart_time()));
//        store.setEnd_time(Time.valueOf(storeDTO.getEnd_time())); // Time 열거형으로 변환
//    }

	
}