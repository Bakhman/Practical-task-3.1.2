package com.bakh.springsecuritydemo.controller;

import com.bakh.springsecuritydemo.model.User;
import com.bakh.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

/**
 * @author Bakhmai Begaev
 */

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String greeting() {
        return "index";
    }

    @GetMapping("/user")
    public String userGreeting() {
        return "user";
    }

    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList", userList);
        return "user-list";
    }

    @GetMapping("create-user")
    public String createUserForm(User user, Model model) {
        model.addAttribute("user", user);
        return  "create-user";
    }

    @PostMapping("/create-user")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "get-user";
    }


    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model) {
        model.addAttribute(userService.findUserById(id));
        return "create-user";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}
