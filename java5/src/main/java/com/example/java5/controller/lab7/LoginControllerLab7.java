package com.example.java5.controller.lab7;

import com.example.java5.model.Account;
import com.example.java5.repository.AccountDAO;
import com.example.java5.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginControllerLab7 {

    @Autowired
    AccountDAO accDao;

    @Autowired
    SessionService session;

    @GetMapping("/login")
    public String index(@ModelAttribute("account") Account account) {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @Validated @ModelAttribute("account") Account account, BindingResult result) {
        if (!result.hasErrors()) {
            Account acc = null;
            try {
                acc = accDao.findById(account.getUsername()).get();
                if (acc.getPassword().equals(account.getPassword())) {
                    session.set("user", acc);
                    String uri = session.get2("security-uri");
                    if (uri != null) {
                        if (!uri.equals("") && uri.contains("/admin/")) {
                            return "redirect:/admin/index";
                        } else if (uri.contains("/account/")) {
                            return "redirect:/account/index";
                        } else
                            return "account";
                    } else
                        return "account";
                } else {
                    model.addAttribute("error_loginPass", "Password không đúng!");
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                model.addAttribute("error_loginUsername", "Username không tồn tại!");
            }

        }
        return "login";
    }

    @PostMapping("/logout")
    public String logout(@ModelAttribute("account") Account account) {
        session.remove("user");
        session.remove("security-uri");
        return "redirect:/login";
    }
}
