package com.materialsmanager.materialsmanager.controller;

import java.util.List;
import java.util.Map;

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
     * @return mainService.getStuffList()
     */
    @ResponseBody
    @RequestMapping(value = "/getStuffList", method = RequestMethod.GET)
    public List<Map<String, Object>> getStuffList() {
        log.debug("call getStuffList()");

        return mainService.getStuffList();
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
    @RequestMapping(value = "/insetStuff", method = RequestMethod.POST)
    public void insetStuff(MainDto mainDto) {

        log.debug("call insetStuff() {}", mainDto);

        mainService.insertStuff(mainDto);
    }


}
