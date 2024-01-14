package com.example.java5.controller;

import com.example.java5.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class ModelAttributeController {
    @RequestMapping("/commentForm")
    public String commentForm() {
        return "comment";
    }

    @RequestMapping(value = "/commentSubmit", method = RequestMethod.POST)
    public String submitForm(
            @RequestParam("name") String name, @RequestParam("comment") String comment, ModelMap model
    ) {
        Comment cmt = new Comment(name, comment);
        model.put("cmt", cmt);
        return "form";
    }

    @ModelAttribute
    public void addAtttribute(Model model){
        model.addAttribute("msg2", "Lê Văn Hùng");
    }
}
