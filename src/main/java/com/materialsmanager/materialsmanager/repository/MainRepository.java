package com.materialsmanager.materialsmanager.repository;

import java.util.List;
import java.util.Map;

import com.materialsmanager.materialsmanager.DTO.MainDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainRepository {
    List<Map<String, Object>> getStuffList();
    void insertStuff(MainDto mainDto);
}
