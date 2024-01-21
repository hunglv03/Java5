package com.example.java5.controller.baiTapTrenLop;

import com.example.java5.model.Staff;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StaffController {
    @GetMapping("/staff/index")
    public String index(Model model) {
        Staff st = new Staff();
        st.setId("hunglv");
        st.setFullName("Lê Văn Hùng");
        st.setEmail("hunglvph25428@gmail.com");
        st.setGender(true);
        st.setPosition("MAN");
        model.addAttribute("staff", st);
        return "staff";
    }

    @PostMapping("/staff/save")
    public String save(@Valid @ModelAttribute("staff") Staff staff) {
        return "detailStaff";
    }
}
