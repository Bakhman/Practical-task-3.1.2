package com.bakh.springsecurity312.controller;

import com.bakh.springsecurity312.model.Role;
import com.bakh.springsecurity312.model.User;
import com.bakh.springsecurity312.service.RoleServiceImpl;
import com.bakh.springsecurity312.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bakhmai Begaev
 */
@Controller
@RequestMapping()
public class AdminController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "admin/user-list";
    }

    @GetMapping("/createUser")
    public String createUserForm(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("user", new User());
        model.addAttribute("rolesList", roles);
        return  "admin/create-user";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user")  User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("user", userService.findUserById(id));
        model.addAttribute("rolesList", roles);
        return "admin/create-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, User user) {
        userService.editUser(user);
        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}
