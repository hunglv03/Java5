package com.example.java5.controller.lab4;

import com.example.java5.service.CookieService;
import com.example.java5.service.ParamService;
import com.example.java5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
        return "account/login";
    }

    @PostMapping("/account/login")
    public String login2() {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);
        if (un.equals("poly") && pw.equals("123")) {
            sessionService.set("un", un);
            if (rm) {
                cookieService.add("user", un, 10);
                cookieService.add("pass", pw, 10);
            } else {
                cookieService.remove("user");
                cookieService.remove("pass");
            }
            System.out.println("Đăng nhập thành công");
        } else {
            System.out.println("Đăng nhập thất bại");
        }
        return "account/login";
    }

}
