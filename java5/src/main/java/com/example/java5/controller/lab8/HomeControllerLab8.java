package com.example.java5.controller.lab8;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllerLab8 {
    @RequestMapping("/homeLab8/index")
    public String index() {
        return "home/index";
    }

    @RequestMapping("/homeLab8/about")
    public String about() {
        return "home/about";
    }
}
