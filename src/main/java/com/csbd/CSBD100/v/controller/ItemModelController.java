package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.exception.ItemNotFoundException;
import com.csbd.CSBD100.v.exception.UserNotFoundException;
import com.csbd.CSBD100.v.model.dto.ItemModelDTO;

import com.csbd.CSBD100.v.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.csbd.CSBD100.v.controller.UserController.CLEANER;
import static com.csbd.CSBD100.v.controller.UserController.POSITIVE;

@Controller
public class ItemModelController {

    @Autowired
    private ItemService itemService;

    private String reqAdd = "", reqDel = "";
    @GetMapping("/item")
    public String ViewItem(Model model) {
        model.addAttribute("items", itemService.getItemsDTO());
        model.addAttribute("reqAdd", reqAdd);
        model.addAttribute("reqDeleted", reqDel);
        model.addAttribute("itemToInsert", new ItemModelDTO());
        reqAdd = reqDel = CLEANER;
        return "item";
    }

    @PostMapping("/delete-item")
    public String deleteUser(@ModelAttribute("item") ItemModelDTO itemModelDTO) {
        itemService.deleteItem(itemModelDTO.getId());
        return "redirect:/item";
    }
    @PostMapping("/item")
    public String addNewView(@ModelAttribute ItemModelDTO itemModelDTO) {
        try {
        itemService.addItemDTO(itemModelDTO);
            reqAdd = POSITIVE;
    } catch (
    ItemNotFoundException e) {
        reqAdd = e.getMessage();
    }
        return "redirect:/item";
    }
}
