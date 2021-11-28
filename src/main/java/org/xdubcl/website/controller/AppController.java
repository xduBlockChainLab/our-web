package org.xdubcl.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.xdubcl.website.model.User;
import org.xdubcl.website.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {

        /**
         * @description 避免在数据库能看到用户密码的问题
         */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);

        return "register_success";
    }

    @GetMapping("/list_users")
    public String viewuserlist(Model model) {
        Iterable<User> listUsers = repo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/test")
    public String HomePage() {


        return "homepage";
    }


    @GetMapping("/xvanze")
    public String Xvanzeti() {


        return "xvanzeti";
    }


}

