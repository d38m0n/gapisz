package com.csbd.CSBD100.v.service.user;

import com.csbd.CSBD100.v.exception.UserNotFoundException;
import com.csbd.CSBD100.v.model.dto.UserDTO;
import com.csbd.CSBD100.v.model.entity.ClientEntity;
import com.csbd.CSBD100.v.model.entity.UserEntity;
import com.csbd.CSBD100.v.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public UserEntity getUserEntity (){
        UserEntity userEntity = userRepository
                .findByLogin(getUser())
                .orElseThrow(() -> new UserNotFoundException("Not find", HttpStatus.BAD_REQUEST));
        return userEntity;
    }

    public String getUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.printf(authentication.getName());
        return authentication.getName();
    }

    public void addUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO,UserEntity.class);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity = userRepository.save(userEntity);

    }
    public List<ClientEntity> getClients(){
       return getUserEntity().getClientEntities();

    }
    public void  upload (UserEntity userEntity){
                userRepository.save(userEntity);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
