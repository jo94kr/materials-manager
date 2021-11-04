package com.materialsmanager.materialsmanager.service;

import java.util.List;

import com.materialsmanager.materialsmanager.repository.MainRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    
    @Autowired
    MainRepository mainRepository;

    public List<String> testService() {
        List<String> result = mainRepository.test();

        return result;
    }
}
