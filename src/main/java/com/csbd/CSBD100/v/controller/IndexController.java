package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    public static String nameUser;
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String defaultView() {
        return "index";
    }

    @GetMapping("/index")
    public String indexView() {
        return "index";
    }

}

