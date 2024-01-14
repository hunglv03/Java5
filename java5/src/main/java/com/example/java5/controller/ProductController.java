package com.example.java5.controller;

import com.example.java5.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @GetMapping("/product/form")
    public String form() {
        return "product/formProduct";
    }

    @PostMapping("/product/save")
    public String save(@RequestParam("name") String name, @RequestParam("price") double price, Model model) {
        Product product = new Product(name, price);
        model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());
        return "product/formProduct";
    }
}
