package com.materialsmanager.materialsmanager.controller;

import java.util.List;

import com.materialsmanager.materialsmanager.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    
    @Autowired
    MainService mainService;

    @RequestMapping(value="/")
    public String index() {
        return "/index";
	}

    
    @GetMapping("/test")
    public @ResponseBody List<String> test(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println(mainService.testService());

        return mainService.testService();
	}
}
