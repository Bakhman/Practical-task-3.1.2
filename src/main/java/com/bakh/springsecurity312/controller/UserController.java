package com.bakh.springsecurity312.controller;

import com.bakh.springsecurity312.model.User;
import com.bakh.springsecurity312.service.UserDetailsServiceImpl;
import com.bakh.springsecurity312.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * @author Bakhmai Begaev
 */
@Controller
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getUser(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = user.getId();
        user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "get-user";
    }
}
