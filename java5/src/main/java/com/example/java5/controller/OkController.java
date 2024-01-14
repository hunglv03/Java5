package com.example.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl")
public class OkController {
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/ok1")
    public String ok() {
        request.setAttribute("ok", "Gọi ok()");
        return "ok";
    }

    @PostMapping("/ok")
    public String m1(Model model) {
        request.setAttribute("ok", "Gọi m1()");
        return "ok";
    }

    @GetMapping("/ok")
    public String m2(Model model) {
        request.setAttribute("ok", "Gọi m2()");
        return "ok";
    }

    @RequestMapping(value = "/ok", params = "x")
    public String m3(Model model) {
        request.setAttribute("ok", "Gọi m3()");
        return "ok";
    }
}
