package com.csbd.CSBD100.v.service.user;

import com.csbd.CSBD100.v.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


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

    public String getUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.printf(authentication.getName());
        return authentication.getName();
    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
