package com.example.java5.controller.baiTapTrenLop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam String name,
                        @RequestParam(name = "location", required = false, defaultValue = "VietNam") String address,
                        Model model) {
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        return "login";
    }
}
