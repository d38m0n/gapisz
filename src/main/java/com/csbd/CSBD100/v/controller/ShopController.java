package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.model.dto.ItemModelDTO;
import com.csbd.CSBD100.v.service.ItemService;
import com.csbd.CSBD100.v.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShopController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/shop")
    public ModelAndView storyView(HttpServletRequest req) {
        String idClient = req.getParameter("id_client");

        List<ItemModelDTO> items = itemService.getItemsDTO();
        return new ModelAndView("shop","items",items)
                .addObject("id_client",idClient);
    }
    @PostMapping("/shop")
    public  String addItem(@ModelAttribute("id") Long iD, @ModelAttribute("clientName") String client){
          clientService.addItem(client,iD);
        return "redirect:/shop?id_client="+client;
    }
}
