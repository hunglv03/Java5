package com.example.java5.controller.lab7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountControllerLab7 {
	
	@GetMapping("/account/index")
	public String index() {
		return "account";
	}
}
