package com.csbd.CSBD100.v.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String defaultView() {
        return "index";
    }

    @GetMapping("/index")
    public String indexView() {
        return "index";
    }
}


