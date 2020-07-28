package com.csbd.CSBD100.v.service.user;

import com.csbd.CSBD100.v.exception.UserNotFoundException;
import com.csbd.CSBD100.v.model.dto.ItemModelDTO;
import com.csbd.CSBD100.v.model.dto.UserDTO;
import com.csbd.CSBD100.v.model.entity.ItemModelEntity;
import com.csbd.CSBD100.v.model.entity.UserEntity;
import com.csbd.CSBD100.v.repository.ItemModelRepository;
import com.csbd.CSBD100.v.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    private ItemModelRepository itemModelRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(ModelMapper modelMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity getUserEntity() throws UserNotFoundException {
        return userRepository
                .findByLogin(getUser())
                .orElseThrow(() -> new UserNotFoundException("Not find", HttpStatus.BAD_REQUEST));
    }

    public String getUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public void addUser(UserDTO userDTO) throws UserNotFoundException {

        UserEntity uE = Optional.of(modelMapper.map(userDTO, UserEntity.class))
                .filter(u -> checkingAvailableLogin(userDTO.getLogin(), userDTO.getEmail()))
                .map(u -> u.setPassword(passwordEncoder.encode(userDTO.getPassword())))
                .orElseThrow(() -> new UserNotFoundException("This Login or Email Exist", HttpStatus.CONFLICT));

        upload(uE);
    }

    public void addItemDTO(ItemModelDTO itemModelDTO) throws UserNotFoundException {
        UserEntity userEntity = userRepository
                .findByLogin(getUser()).get();

        ItemModelEntity itemEntity = Optional.of(modelMapper.map(itemModelDTO, ItemModelEntity.class))
                .filter(i -> checkingAvailableBrandCode(itemModelDTO.getBrandCode()))
                .orElseThrow(() -> new UserNotFoundException("This Login or Email Exist", HttpStatus.CONFLICT));

        userEntity.addItem(itemEntity);

        upload(userEntity);
    }


    private boolean checkingAvailableLogin(String login, String email) {
        return userRepository.findAll().stream()
                .filter(u -> u.getLogin().equals(login) || u.getEmail().equals(email))
                .findFirst()
                .isEmpty();
    }

    private boolean checkingAvailableBrandCode(String brandCode) {
        return getUserEntity().getItemsUser().stream()
                .filter(i -> i.getBrandCode().equals(brandCode))
                .findAny()
                .isEmpty();
    }

    public List<ItemModelDTO> getItemsDTO() {
        return getUserEntity()
                .getItemsUser()
                .stream()
                .map(item -> modelMapper.map(item, ItemModelDTO.class))
                .collect(Collectors.toList());
    }

    public void upload(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> modelMapper.map(u, UserDTO.class))
                .collect(Collectors.toList());
    }


}
