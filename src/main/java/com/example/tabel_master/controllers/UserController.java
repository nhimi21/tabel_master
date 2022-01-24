package com.example.tabel_master.controllers;

import com.example.tabel_master.models.User;
import com.example.tabel_master.services.UserService;
import com.example.tabel_master.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    //User Controller for LogIn(LogOut) and Registration
    @GetMapping("/")
    public String index(@ModelAttribute("user") User user,HttpSession session,Model model) {
        return "/user/registration";
    }

    //Register form controller
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/user/registration";
        } else {
            User u = userService.registerUser(user);
            session.setAttribute("userId", u.getId());
        }
        return "redirect:/home";
    }

    //LogIn form controller
    @PostMapping(value = "/login")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            Model model,
                            RedirectAttributes redirectAttr,
                            HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            User user = userService.findUserByEmail(email);
            session.setAttribute("userId", user.getId());
            return "redirect:/home";
        } else {
            redirectAttr.addFlashAttribute("loginError", "Invalid credentials!");
            return "redirect:/";
        }
    }

    //LogOut Form Controller
    @RequestMapping("/logout")
    public String logout(HttpSession session,Model model) {
        session.invalidate();
        return "redirect:/";
    }

}
