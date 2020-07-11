package com.csbd.CSBD100.v.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceManagerController {
    @GetMapping("/resource-manager")
    public String resourceView (){return "resource-manager";}
}
