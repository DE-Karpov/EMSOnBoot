package ru.itis.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.transfer.UserDto;
import ru.itis.demo.security.details.UserDetailsImpl;

import static ru.itis.demo.transfer.UserDto.from;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getProfilePage(ModelMap modelMap, Authentication authentication){
        if(authentication == null){
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        modelMap.addAttribute("user", user.getFullName());
        return "profile";
    }
}
