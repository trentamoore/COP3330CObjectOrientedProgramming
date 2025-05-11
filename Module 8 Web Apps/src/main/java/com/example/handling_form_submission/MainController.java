package com.example.handling_form_submission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "home"; // Must map to home.html
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Must map to login.html
    }
}