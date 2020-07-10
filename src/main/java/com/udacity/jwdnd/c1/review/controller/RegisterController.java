package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.User;
import com.udacity.jwdnd.c1.review.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String getRegister(){
        return "register";
    }

    @PostMapping
    public String signUpUser(@ModelAttribute User user, Model model){
        String signupError = null;

        if(!userService.isUsernameAvailable(user.getUsername())){
            signupError = "The username already exists";
        }

        if(signupError == null){
            int rowsCreated = userService.createUser(user);
            if(rowsCreated < 0){
                signupError = "There was an error registering you, please try again!";
            }
        }

        if(signupError == null){
            model.addAttribute("signupSuccess", true);
        } else {
            model.addAttribute("signupError", signupError);
        }

        return "register";
    }
}
