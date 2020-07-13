package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.model.dto.UserDTO;
import com.csbd.CSBD100.v.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/d38m0n")
    public String d38m0n() {
        return "admin-console";
    }

    @GetMapping("/add-user")
    public ModelAndView userView() {
        return new ModelAndView("add-user", "userToInsert", new UserDTO());
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute UserDTO userDto) {
        userService.addUser(userDto);
        return "redirect:/index";
    }
}
