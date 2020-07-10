package com.udacity.jwdnd.c1.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    String getLogin(){
        return "login";
    }
}
