package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.model.dto.UserDTO;
import com.csbd.CSBD100.v.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/d38m0n")
    public String d38m0n() {
        return "admin-console";
    }



    @GetMapping("/user")
    public String userView( Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("userToInsert",new UserDTO());
        return "/user";
    }

    @PostMapping("/delete-user")
    public String deleteUser(@ModelAttribute("user") UserDTO user){
        userService.deleteUser(user.getId());
        return "redirect:/user";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute UserDTO userDto) {
        userService.addUser(userDto);
        return "redirect:/user";
    }
}
