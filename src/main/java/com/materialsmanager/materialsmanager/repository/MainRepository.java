package com.materialsmanager.materialsmanager.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainRepository {
    List<String> test();
}
