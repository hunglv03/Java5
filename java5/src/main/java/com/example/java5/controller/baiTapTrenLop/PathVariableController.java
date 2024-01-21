package com.example.java5.controller.baiTapTrenLop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PathVariableController {
    @GetMapping("/pathVariable/{variable1}/{variable2}")
    public String pathVariable(@PathVariable(name = "variable1") String var1,
                               @PathVariable(name = "variable2") String var2, Model model) {
        model.addAttribute("var1", var1);
        model.addAttribute("var2", var2);
        return "path";
    }
}
