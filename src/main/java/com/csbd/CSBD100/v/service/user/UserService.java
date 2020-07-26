package com.csbd.CSBD100.v.service.user;

import com.csbd.CSBD100.v.exception.UserNotFoundException;
import com.csbd.CSBD100.v.model.dto.UserDTO;
import com.csbd.CSBD100.v.model.entity.ClientEntity;
import com.csbd.CSBD100.v.model.entity.UserEntity;
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

        UserEntity createUser = Optional.of(modelMapper.map(userDTO, UserEntity.class))
                .filter(u -> checkingAvailableLogin(userDTO.getLogin(), userDTO.getEmail()))
                .map(u -> u.setPassword(passwordEncoder.encode(userDTO.getPassword())))
                .orElseThrow(() -> new UserNotFoundException("This Login or Email Exist", HttpStatus.CONFLICT));

        userRepository.save(createUser);
    }

    private boolean checkingAvailableLogin(String login, String email) {
        return userRepository.findAll().stream()
                .filter(u -> u.getLogin().equals(login) || u.getEmail().equals(email))
                .findFirst()
                .isEmpty();
    }


    public List<ClientEntity> getClients() {
        return getUserEntity().getClientEntities();
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
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

}
