package com.materialsmanager.materialsmanager.service;

import java.util.List;

import com.materialsmanager.materialsmanager.DTO.StuffDto;
import com.materialsmanager.materialsmanager.repository.MainRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    
    @Autowired
    MainRepository mainRepository;

    public List<String> getCategoryList() {
        List<String> categoryList = mainRepository.getCategoryList();

        return categoryList;
    }

    public List<StuffDto> getStuffList(List<String> categoryList) {
        List<StuffDto> stuffList = mainRepository.getStuffList(categoryList);

        return stuffList;
    }

    public void insertStuff(StuffDto mainDto) {
        mainRepository.insertStuff(mainDto);
    }

}
