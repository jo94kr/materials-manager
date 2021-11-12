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

    public List<Map<String, Object>> getStuffList() {
        List<Map<String, Object>> stuffList = mainRepository.getStuffList();
        Map<String, Object> result = new HashMap<String, Object>();
        List<Map<String, Object>> resultList = null;

        String category = null;
        System.out.println(result);

        for (Map<String, Object> stuffMap : stuffList) {
            category = stuffMap.get("STUFF_CATEGORY").toString();
            resultList = new ArrayList<Map<String, Object>>();
            resultList.add(stuffMap);
            result.put(category, resultList);

        }

        return stuffList;
    }

    public void insertStuff(MainDto mainDto) {
        mainRepository.insertStuff(mainDto);
    }

}
