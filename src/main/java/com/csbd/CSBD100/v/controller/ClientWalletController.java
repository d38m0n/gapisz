package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.exception.UserNotFoundException;
import com.csbd.CSBD100.v.model.dto.ClientDTO;
import com.csbd.CSBD100.v.model.dto.ItemModelDTO;
import com.csbd.CSBD100.v.model.entity.ClientEntity;
import com.csbd.CSBD100.v.model.entity.ItemModelEntity;
import com.csbd.CSBD100.v.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ClientWalletController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public ModelAndView viewWallet(HttpServletRequest req) {
        String idClient = req.getParameter("id_client");
        ClientEntity ce = clientService.viewClient(idClient);
        ClientEntity clientEntity = ce;

            return new ModelAndView ("client-wallet","id_client", clientEntity);

    }

    @PostMapping("/add-client")
    public String addUser(@ModelAttribute ClientDTO clientDTO) {
        return "redirect:/index";
    }

}
