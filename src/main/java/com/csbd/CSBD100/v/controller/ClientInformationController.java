package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.model.dto.ItemModelDTO;
import com.csbd.CSBD100.v.service.ItemService;
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
public class ClientInformationController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/client-information")
    public ModelAndView storyView(HttpServletRequest req) {
        String idClient = req.getParameter("id_client");

        List<ItemModelDTO> items = itemService.getItemsDTO();
        return new ModelAndView("client-information","items",items)
                .addObject("id_client",idClient);
    }

}
