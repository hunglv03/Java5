package com.example.java5.controller.lab5;

import com.example.java5.model.Product2;
import com.example.java5.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class ProductControllerLab5 {
    @Autowired
    ProductDAO repo;

    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Sort.Direction.ASC, field.orElse("price"));
        model.addAttribute("field", field.orElse("price").toUpperCase(Locale.ROOT));
        List<Product2> items = repo.findAll(sort);
        model.addAttribute("items", items);
        return "product/sort";
    }

    @RequestMapping("/product/page")
    public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product2> page = repo.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }
}
