package com.boots.controller;

import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "list";
    }

    @PostMapping("/user")
    public String viewUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("view")){
            userService.findUserById(userId);
        }
        return "view";
    }

    @GetMapping("/user/{userId}")
    public String  getUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.getUserList(userId));
        return "view";
    }
}