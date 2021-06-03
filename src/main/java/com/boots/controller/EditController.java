package com.boots.controller;

import com.boots.entity.Status;
import com.boots.entity.User;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class EditController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}/edit")
    public String registration(@RequestParam(required = true, defaultValue = "") Long userId, Model model) {
        model.addAttribute("editUser", userService.findUserById(userId));
        return "edit";
    }

    @PostMapping("/user/{id}/edit")
    public String editUser(@ModelAttribute("editUser") @Valid User editUser,
                    @RequestParam(required = true, defaultValue = "" ) String action,
                    @RequestParam(required = true, defaultValue = "" ) Long userId,
                    BindingResult bindingResult, Model model) {
        User user = userService.findUserById(userId);
        if (action.equals("lock")){
            user.setStatus(Status.INACTIVE);
            userService.updateUser(user);
            return "redirect:/user/";
        } else if (action.equals("unlock")){
            user.setStatus(Status.ACTIVE);
            userService.updateUser(user);
            return "redirect:/user/";
        }
        if (action.equals("status") || action.equals("role")){
            userService.updateUser(editUser);
            return "redirect:/user/";
        }
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        if (!editUser.getPassword().equals(editUser.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "edit";
        }
        userService.updateUser(editUser);
        return "redirect:/";
    }
}