package com.csbd.CSBD100.v.controller;

import com.csbd.CSBD100.v.exception.ItemNotFoundException;
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
    private final String REFRESH_ITEM_PAGE = "redirect:/item";

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
    public String deleteItem(@ModelAttribute("item") ItemModelDTO itemModelDTO) {
        itemService.deleteItem(itemModelDTO.getId());
        return REFRESH_ITEM_PAGE;
    }

    @PostMapping("/edit-item")
    public String editItem(@ModelAttribute("item") ItemModelDTO itemModelDTO) {
        return REFRESH_ITEM_PAGE;
    }

    @PostMapping("/block-item")
    public String blockItem(@ModelAttribute("item") ItemModelDTO itemModelDTO) {
        itemService.blockItem(itemModelDTO.getId());
        return REFRESH_ITEM_PAGE;
    }

    @PostMapping("/unblock-item")
    public String unblockItem(@ModelAttribute("item") ItemModelDTO itemModelDTO) {
        itemService.unblockItem(itemModelDTO.getId());
        return REFRESH_ITEM_PAGE;
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
        return REFRESH_ITEM_PAGE;
    }
}
