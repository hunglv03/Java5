package com.example.java5.controller.lab3;

import com.example.java5.model.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @RequestMapping("/student/form")
    public String form(@ModelAttribute("sv") Student sv) {
        return "student/form";
    }

    @PostMapping("/student/save")
    public String save(@Valid @ModelAttribute("sv") Student sv, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Có lỗi xảy ra");
            return "student/form";
        } else {
            model.addAttribute("message", "Chúc mừng bạn đã nhập đúng");
            return "student/detail";
        }
    }

    @ModelAttribute("genders")
    public Map<Boolean, String> getGenders() {
        Map<Boolean, String> map = new HashMap<>();
        map.put(true, "Male");
        map.put(false, "Female");
        return map;
    }

    @ModelAttribute("faculties")
    public List<String> getFaculties() {
        return Arrays.asList("CNTT", "DLNHKS", "QTDN");
    }

    @ModelAttribute("hobbies")
    public Map<String, String> getHobbies() {
        Map<String, String> map = new HashMap<>();
        map.put("T", "Travelling");
        map.put("M", "Music");
        map.put("F", "Food");
        map.put("O", "Other");
        return map;
    }
}
