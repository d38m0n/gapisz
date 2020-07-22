package com.csbd.CSBD100.v.model.dto;

import com.csbd.CSBD100.v.model.entity.ClientEntity;
import com.csbd.CSBD100.v.model.entity.ItemModelEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private Long id;
    private String email;
    private String login;
    private String password;
    private String role;
    private String city;
    private String zipCode;
    private boolean isActive;
    private List<ClientEntity> clientEntities = new ArrayList<>();
    private List<ItemModelEntity> itemsUser = new ArrayList<>();

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public List<ItemModelEntity> getItemsUser() {
        return itemsUser;
    }

    public void setItemsUser(List<ItemModelEntity> itemsUser) {
        this.itemsUser = itemsUser;
    }
}
