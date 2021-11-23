package com.materialsmanager.materialsmanager.repository;

import java.util.List;

import com.materialsmanager.materialsmanager.DTO.StuffDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainRepository {
    List<String> getCategoryList();
    List<StuffDto> getStuffList(List<String> categoryList);
    void insertStuff(StuffDto mainDto);
}
