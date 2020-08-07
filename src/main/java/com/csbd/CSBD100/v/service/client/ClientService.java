package com.csbd.CSBD100.v.service.client;


import com.csbd.CSBD100.v.exception.UserNotFoundException;
import com.csbd.CSBD100.v.model.dto.ClientDTO;
import com.csbd.CSBD100.v.model.entity.ClientEntity;
import com.csbd.CSBD100.v.repository.ClientRepository;
import com.csbd.CSBD100.v.service.ItemService;
import com.csbd.CSBD100.v.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class ClientService {
    private ModelMapper modelMapper;
    private ClientRepository clientRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    public ClientService(ModelMapper modelMapper, UserService userService, ClientRepository clientRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getClientsDTO() {
        return getClientsEntity()
                .map(c -> modelMapper.map(c, ClientDTO.class))
                .collect(Collectors.toList());
    }

    private Stream<ClientEntity> getClientsEntity() {
        return userService.getUserEntity().getClientEntities().stream();
    }

    public ClientEntity viewClient(String personalID) {
        return upload(findClient(personalID)
                .orElse(new ClientEntity().setAutoCreate(personalID)));
    }

    public void addItem(String client, Long id) {
        ClientEntity c = findClient(client)
                .orElseThrow(() -> new UserNotFoundException("Nof find client", HttpStatus.BAD_REQUEST));
        c.addItem(itemService.getItem(id).setDataAddToClient());
        upload(c);
    }

    private ClientEntity upload(ClientEntity c) {
        ClientEntity clientSava = clientRepository.save(c);
        userService.upload(userService
                .getUserEntity()
                .addClientEntities(clientSava));
        return clientSava;
    }

    private Optional<ClientEntity> findClient(String personalID) {
        return getClientsEntity()
                .filter(c -> c.getPrivatePersonID().equals(personalID))
                .findFirst();
    }


}
