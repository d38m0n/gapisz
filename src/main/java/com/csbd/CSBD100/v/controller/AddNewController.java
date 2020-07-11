package com.csbd.CSBD100.v.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddNewController {
@GetMapping("/add-new")
    public String addNewView(){return "add-new";}
}
