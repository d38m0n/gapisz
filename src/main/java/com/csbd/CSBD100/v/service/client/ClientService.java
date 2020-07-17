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
import java.util.stream.Collectors;


@Service
public class ClientService {
    private ModelMapper modelMapper;


    @Autowired
    private UserService userService;
    private ClientRepository clientRepository;

    public ClientService(ModelMapper modelMapper, UserService userService, ClientRepository clientRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.clientRepository = clientRepository;


    }

    public List<ClientDTO> getClientsDTO() {
        List<ClientEntity> clients = userService.getClients();
        List<ClientDTO> clientDTOList = clients
                .stream()
                .map(user -> modelMapper.map(user, ClientDTO.class))
                .collect(Collectors.toList());

        return clientDTOList;
    }
    public void addNewClient(ClientDTO clientDTO){
        ClientEntity clientEntity = modelMapper.map(clientDTO,ClientEntity.class);
        UserEntity userEntity = userService.getUserEntity();
        userEntity.addClientEntities(clientEntity);
        userService.upload(userEntity);


    }

}
