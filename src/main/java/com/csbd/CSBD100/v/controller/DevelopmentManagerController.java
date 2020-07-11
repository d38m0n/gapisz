package com.csbd.CSBD100.v.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DevelopmentManagerController {
    @GetMapping("/development-manager")
    public String developmentManagerView(){return "development-manager";}
}
