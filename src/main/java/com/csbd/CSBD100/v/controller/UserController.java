package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.exception.UserNotFoundException;
import com.csbd.CSBD100.v.model.dto.UserDTO;
import com.csbd.CSBD100.v.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    public final static String POSITIVE = "  Success";
    public final static String CLEANER = "";

    @Autowired
    private UserService userService;
    private String reqAdd = "", reqDel = "";

    @GetMapping("/d38m0n")
    public String d38m0n() {
        return "admin-console";
    }

    @GetMapping("/user")
    public String userView(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("userToInsert", new UserDTO());
        model.addAttribute("reqAdd", reqAdd);
        model.addAttribute("reqDeleted", reqDel);
        reqAdd = reqDel = CLEANER;
        return "/user";
    }

    @PostMapping("/delete-user")
    public String deleteUser(@ModelAttribute("user") UserDTO user) {
        userService.deleteUser(user.getId());
        reqDel = POSITIVE;
        return "redirect:/user";
    }

    @PostMapping(value = "/user")
    public String addUser(@ModelAttribute UserDTO userDto) {
        try {
            userService.addUser(userDto);
            reqAdd = POSITIVE;
        } catch (UserNotFoundException e) {
            reqAdd = e.getMessage();
        }
        return "redirect:/user";
    }


}
