package com.csbd.CSBD100.v.service;

import com.csbd.CSBD100.v.exception.ItemNotFoundException;
import com.csbd.CSBD100.v.exception.UserNotFoundException;
import com.csbd.CSBD100.v.model.dto.ItemModelDTO;
import com.csbd.CSBD100.v.model.entity.ItemModelEntity;
import com.csbd.CSBD100.v.model.entity.UserEntity;
import com.csbd.CSBD100.v.repository.ItemModelRepository;
import com.csbd.CSBD100.v.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private ItemModelRepository itemModelRepository;
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    public ItemService(ItemModelRepository itemModelRepository, ModelMapper modelMapper, UserService userService) {
        this.itemModelRepository = itemModelRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    public void addItemDTO(ItemModelDTO itemModelDTO) throws UserNotFoundException {
        UserEntity u = userService.getUserEntity()
                .addItem(addItem(itemModelDTO));
        userService.upload(u);
    }

    private ItemModelEntity addItem(ItemModelDTO itemModelDTO) throws UserNotFoundException {
        ItemModelEntity itemEntity = getItemModelEntity(itemModelDTO);
        return itemModelRepository.save(itemEntity.setDateAddToMag());
    }

    public ItemModelEntity getItemModelEntity(ItemModelDTO itemModelDTO) throws UserNotFoundException {
        ItemModelEntity itemEntity = Optional.of(modelMapper.map(itemModelDTO, ItemModelEntity.class))
                .orElseThrow(() -> new ItemNotFoundException("This BrandCode Exist", HttpStatus.CONFLICT));
        return itemEntity;
    }


    public List<ItemModelDTO> getItemsDTO() {
        return userService.getUserEntity()
                .getItems()
                .stream()
                .map(item -> modelMapper.map(item, ItemModelDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteItem(Long id) {
        UserEntity u = userService.getUserEntity();
        u.deleteItemUser(itemModelRepository.findById(id).get());
        itemModelRepository.deleteById(id);
        userService.upload(u);
    }

    public void blockItem(Long id) {
        changeAvailable(id,true);
    }
    public void unblockItem(Long id) {
        changeAvailable(id,false);
    }

    public void editItem(ItemModelDTO itemModelDTO){


    }

    private void changeAvailable(Long id,boolean b) {
        UserEntity u = userService.getUserEntity();
        u.getItems().stream()
                .filter(i -> i.getId().equals(id))
                .map(i->i.setAvailable(b))
                .findFirst();
        userService.upload(u);
    }

    public ItemModelEntity getItem(Long id) {
        return itemModelRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("This id not Exist", HttpStatus.BAD_REQUEST));
    }


}
