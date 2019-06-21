package ru.itis.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.demo.models.Role;
import ru.itis.demo.models.User;
import ru.itis.demo.services.UserService;
import ru.itis.demo.transfer.UserDto;
import ru.itis.demo.security.details.UserDetailsImpl;

import static ru.itis.demo.transfer.UserDto.from;

@Controller
public class ProfileController {

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String getProfilePage(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        } else {
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.ADMIN.name()))) {
                modelMap.addAttribute("admin", true);
            }
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            UserDto userDto = from(details.getUser());
            User user = details.getUser();
            modelMap.addAttribute("user", userDto.getFullName());
            modelMap.addAttribute("login", user.getLogin());
            modelMap.addAttribute("age", user.getAge());
            modelMap.addAttribute("gender", user.getGender());
            modelMap.addAttribute("address", userService.parseOfAddress(user.getAddresses()));
            return "profile";
        }
    }
}
