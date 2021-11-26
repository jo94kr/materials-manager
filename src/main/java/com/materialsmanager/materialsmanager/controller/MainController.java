package com.materialsmanager.materialsmanager.controller;

import java.util.List;

import com.materialsmanager.materialsmanager.DTO.StuffDto;
import com.materialsmanager.materialsmanager.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping(value="/")
    public String index() {
        return "/test";
	}

    @ResponseBody
    @RequestMapping(value = "/getCategoryList", method = RequestMethod.GET)
    public List<String> getCategoryList() {
        log.debug("call getCategoryList");

        List<String> categoryList = mainService.getCategoryList();
        return categoryList;
    }

    /**
     * 
     * @return stuffList
     */
    @ResponseBody
    @RequestMapping(value = "/getStuffList", method = RequestMethod.GET)
    public List<StuffDto> getStuffList(
        @RequestParam(value = "categoryList") List<String> categoryList
    ) {
        log.info("call getStuffList(categoryList : {})", categoryList);

        List<StuffDto> stuffList = mainService.getStuffList(categoryList);
        return stuffList;
	}

    /**
     * 
     * @param stuffCategory
     * @param stuffName
     * @param stuffCount
     * @param rentalCount
     * @param returnCount
     */
    @ResponseBody
    @RequestMapping(value = "/insetStuff", method = RequestMethod.POST)
    public void insetStuff(@RequestBody StuffDto mainDto) {
        log.info("call insetStuff() {}", mainDto);

        mainService.insertStuff(mainDto);
    }


}
