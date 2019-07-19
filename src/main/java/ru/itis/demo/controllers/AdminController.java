package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.demo.services.AdminService;

@Controller
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @PostMapping("users/changeState")
    public String changeState(Authentication authentication, @RequestParam Long id, @RequestParam String state){
        if (authentication != null){
            adminService.changeState(id, state);
        }
        return "users";
    }
}
