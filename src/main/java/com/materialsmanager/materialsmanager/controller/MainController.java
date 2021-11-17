package com.materialsmanager.materialsmanager.controller;

import java.util.List;

import com.materialsmanager.materialsmanager.DTO.MainDto;
import com.materialsmanager.materialsmanager.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping(value="/")
    public String index() {
        return "/index";
	}

    /**
     * 물품 리스트를 리턴
     * 
     * @return stuffList
     */
    @ResponseBody
    @RequestMapping(value = "/getStuffList", method = RequestMethod.GET)
    public List<MainDto> getStuffList() {
        log.debug("call getStuffList()");

        List<MainDto> stuffList = mainService.getStuffList();

        return stuffList;
	}

    /**
     * 물품 추가
     * 
     * @param stuffCategory
     * @param stuffName
     * @param stuffCount
     * @param rentalCount
     * @param returnCount
     */
    @ResponseBody
    @RequestMapping(value = "/insetStuff", method = RequestMethod.POST)
    public void insetStuff(MainDto mainDto) {

        log.debug("call insetStuff() {}", mainDto);

        mainService.insertStuff(mainDto);
    }


}
