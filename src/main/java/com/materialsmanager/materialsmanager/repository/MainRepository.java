package com.materialsmanager.materialsmanager.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainRepository {
    List<Map<String, Object>> getStuffList();
}
