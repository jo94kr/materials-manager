package com.materialsmanager.materialsmanager.repository;

import java.util.List;

import com.materialsmanager.materialsmanager.DTO.MainDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainRepository {
    List<MainDto> getStuffList();
    void insertStuff(MainDto mainDto);
}
