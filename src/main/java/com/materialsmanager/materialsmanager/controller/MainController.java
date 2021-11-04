package com.materialsmanager.materialsmanager.controller;

import java.util.List;
import java.util.Map;

import com.materialsmanager.materialsmanager.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @Autowired
    MainService mainService;

    @RequestMapping(value="/")
    public String index() {
        return "/index";
	}

    @ResponseBody
    @RequestMapping(value = "/getStuffList", method = RequestMethod.GET)
    public List<Map<String, Object>> getStuffList() {
        return mainService.getStuffList();
	}
}
