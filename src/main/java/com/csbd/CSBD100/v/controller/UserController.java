package com.csbd.CSBD100.v.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/d38m0n")
    public String d38m0n() {
        return "admin-console";
    }
}
