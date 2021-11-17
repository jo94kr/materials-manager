package com.materialsmanager.materialsmanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.materialsmanager.materialsmanager.DTO.MainDto;
import com.materialsmanager.materialsmanager.repository.MainRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    
    @Autowired
    MainRepository mainRepository;

    public List<MainDto> getStuffList() {
        List<MainDto> stuffList = mainRepository.getStuffList();
        Map<String, Object> result = new HashMap<String, Object>();

        String category = null;
        for (MainDto stuffMap : stuffList) {
            category = stuffMap.getStuffCategory();

        }

        return stuffList;
    }

    public void insertStuff(MainDto mainDto) {
        mainRepository.insertStuff(mainDto);
    }

}
