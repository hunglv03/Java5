package com.example.java5.controller.lab7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorController {
	
	@GetMapping("/home/index")
	public String index() {
		return "interceptor";
	}
	
	@GetMapping("/home/category")
	public String category() {
		return "interceptor";
	}
}
