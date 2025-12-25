package com.controller;

import com.entity.UserEntity;
import com.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignInController {
    @Autowired
    private UserService userService;
    // ===================== SIGNUP =====================


    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "SignIn";   // signup.html
    }

    @PostMapping("/signup")
    public String signupUser(@ModelAttribute("user") UserEntity user,
                             Model model) {

        String message = userService.register(user);
        model.addAttribute("message", message);
        return "SignIn";
    }     
    }

