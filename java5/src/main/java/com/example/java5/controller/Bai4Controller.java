package com.example.java5.controller;

import com.example.java5.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class Bai4Controller {
    @GetMapping("/bai4/form")
    public String form(Model model) {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        model.addAttribute("p", p);
        return "product/formBai4";
    }

    @PostMapping("/bai4/save")
    public String save(@ModelAttribute("p") Product p) {
        return "product/formBai4";
    }

    @ModelAttribute("items")
    public List<Product> getItems() {
        return Arrays.asList(new Product("A", 1.0), new Product("B", 12.0));
    }
}
