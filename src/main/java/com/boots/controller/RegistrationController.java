package com.boots.controller;

import com.boots.entity.User;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/new")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "new";
    }

    @PostMapping("/user/new")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        String password = userForm.getPassword();
        if (!password.equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "new";
        }
        if (!password.matches("^[a-zA-Z0-9]*$")){
            model.addAttribute("passwordError", "Please use only latin symbols and numbers");
            return "new";
        }
        if (!password.matches(".*[a-zA-Z].*")){
            model.addAttribute("passwordError", "Please use min 1 latin symbol");
            return "new";
        }
        if (!password.matches(".*\\d.*")){
            model.addAttribute("passwordError", "Please use min 1 number");
            return "new";
        }
        if (password.length() < 3 || password.length() > 16){
            model.addAttribute("passwordError", "Please use from 3 to 16 symbols");
            return "new";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "new";
        }
        return "redirect:/";
    }
}
