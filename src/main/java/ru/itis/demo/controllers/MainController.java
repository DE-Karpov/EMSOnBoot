package ru.itis.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/profile";
        }
        return "main";
    }
}
