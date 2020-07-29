package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.model.dto.ItemModelDTO;

import com.csbd.CSBD100.v.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemModelController {
    @Autowired
    private UserService userService;
    @GetMapping("/item")
    public String ViewItem(Model model) {
        model.addAttribute("items", userService.getItemsDTO());
        model.addAttribute("reqAdd", "reqAdd");
        model.addAttribute("reqDeleted", "reqDel");
        model.addAttribute("itemToInsert", new ItemModelDTO());
        return "item";
    }

    @PostMapping("/delete-item")
    public String deleteUser(@ModelAttribute("item") ItemModelDTO itemModelDTO) {
        userService.deleteItem(itemModelDTO.getId());

        return "redirect:/item";
    }
    @PostMapping("/item")
    public String addNewView(@ModelAttribute ItemModelDTO itemModelDTO) {
        userService.addItemDTO(itemModelDTO);
        return "redirect:/item";
    }
}
