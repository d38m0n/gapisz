package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.model.dto.ClientDTO;
import com.csbd.CSBD100.v.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClientWalletController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add-client")
    public String addUser(@ModelAttribute ClientDTO clientDTO) {

        return "redirect:/index";
    }

}
