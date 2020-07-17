package com.csbd.CSBD100.v.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String login;
    private String password;
    private String role;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_clients",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "client_id")})
    private List<ClientEntity> clientEntities = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_intems",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<ItemModelEntity> itemsUser = new ArrayList<>();

    public List<ItemModelEntity> getItemsUser() {
        return itemsUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<ClientEntity> getClientEntities() {
        return clientEntities;
    }

    public void setClientEntities(List<ClientEntity> clientEntities) {
        this.clientEntities = clientEntities;
    }
    public void addClientEntities(ClientEntity clientEntity){
        this.clientEntities.add(clientEntity);
    }

    public void setItemsUser(List<ItemModelEntity> itemsUser) {
        this.itemsUser = itemsUser;
    }
}
