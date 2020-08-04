package com.csbd.CSBD100.v.service.client;


import com.csbd.CSBD100.v.model.dto.ClientDTO;
import com.csbd.CSBD100.v.model.entity.ClientEntity;
import com.csbd.CSBD100.v.model.entity.UserEntity;
import com.csbd.CSBD100.v.repository.ClientRepository;
import com.csbd.CSBD100.v.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClientService {
    private ModelMapper modelMapper;
    private ClientRepository clientRepository;

    @Autowired
    private UserService userService;

    public ClientService(ModelMapper modelMapper, UserService userService, ClientRepository clientRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getClientsDTO() {
        return userService.getUserEntity().getClientEntities().stream()
                .map(c -> modelMapper.map(c, ClientDTO.class))
                .collect(Collectors.toList());
    }

    public  ClientEntity viewClient(String personalID) {
        ClientEntity c = findClient(personalID)
                .orElse(new ClientEntity().setAutoCreate(personalID));

        UserEntity userEntity = userService
                .getUserEntity()
                .addClientEntities(clientRepository.save(c));

        userService.upload(userEntity);
        return c;
    }

    private Optional<ClientEntity> findClient(String personalID) {
        return userService.getUserEntity().getClientEntities().stream()
                .filter(c -> c.getPrivatePersonID().equals(personalID))
                .findFirst();
    }

    private ClientEntity createClientEntity(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, ClientEntity.class);
    }

}
