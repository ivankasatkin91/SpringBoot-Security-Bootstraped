package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.security.Principal;

import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.SecurityService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/user")
    public String showUserPage(Principal principal, Model model) {
        User user = securityService.findByUsername(principal.getName());
        model.addAttribute("current_user", user);
        return "user_view";
    }

    @GetMapping("/admin")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/admin/new")
    public String addUser(Model model) {
        model.addAttribute("new_user", new User());
        model.addAttribute("all_roles", roleService.listRoles());
        return "new_user";
    }

    @PostMapping("admin/new_save")
    public String saveUSer(@ModelAttribute("new_user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("edit_user", userService.getUserById(id));
        model.addAttribute("all_roles", roleService.listRoles());
        return "edit_user";
    }

    @PatchMapping("admin/{id}")
    public String updateUser(@ModelAttribute("edit_user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("admin/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
