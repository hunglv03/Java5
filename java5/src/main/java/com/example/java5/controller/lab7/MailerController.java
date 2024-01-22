package com.example.java5.controller.lab7;

import com.example.java5.model.MailInfo;
import com.example.java5.service.MailerService;
import com.example.java5.service.impl.MailerServiceImpl;
import jakarta.mail.MessagingException;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

@Controller
public class MailerController {
    @Autowired
    MailerService mailer1;

    @Autowired
    MailerServiceImpl mailer;

    @Autowired
    ServletContext app;

    @ResponseBody
    @RequestMapping("/mailer/demo")
    public String demo(Model model) {
        mailer1.queue("receiver@gmail.com", "Subject", "Body");
        return "Mail của bạn sẽ được gửi đi trong giây lát";
    }

    @GetMapping("/mail")
    public String mail(Model model, @ModelAttribute("mail") MailInfo mail) {
        return "mail";
    }

    @PostMapping("/mail/send")
    public String mail_send(Model model, @Validated @ModelAttribute("mail") MailInfo mail, BindingResult result, @RequestParam("files") MultipartFile[] files) {
        if (!result.hasErrors()) {
            if (!Arrays.asList(files).get(0).getOriginalFilename().equals("")) {
                String[] attachments = new String[files.length];
                int attachSize = -1;
                for (MultipartFile file : files) {
                    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                    attachSize++;
                    try {
                        String uploadDir = System.getProperty("user.dir") + "/uploads/";
                        Path uploadPath = Paths.get(uploadDir);
                        if (!Files.exists(uploadPath)) {
                            Files.createDirectories(uploadPath);
                        }
                        System.out.println("Thư mục uploads được tạo tại: " + uploadDir);
                        Path path = Paths.get(uploadDir + fileName);
                        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                        attachments[attachSize] = path.toString();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                mail.setAttachments(attachments);
            }
            try {
                mailer.queue(mail);
                model.addAttribute("success_sendEmail", "Email sẽ được gửi trong giây lát!");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return "mail";
    }
}
