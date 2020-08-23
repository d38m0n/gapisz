package com.csbd.CSBD100.v.model.dto;

import com.csbd.CSBD100.v.model.entity.CustomerDataEntity;
import com.csbd.CSBD100.v.model.entity.ItemModelEntity;

import java.util.ArrayList;
import java.util.List;

public class ClientDTO {
    private int idClient;
    private String status;
    private String privatePersonID;
    private CustomerDataEntity customerDataEntity;
    private List<ItemModelEntity> Items = new ArrayList<>();
    private String sumOfBuy;

    public String getSumOfBuy() {
        return sumOfBuy;
    }

    public void setSumOfBuy(String sumOfBuy) {
        this.sumOfBuy = sumOfBuy;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrivatePersonID() {
        return privatePersonID;
    }

    public void setPrivatePersonID(String privatePersonID) {
        this.privatePersonID = privatePersonID;
    }

    public CustomerDataEntity getCustomerDataEntity() {
        return customerDataEntity;
    }

    public void setCustomerDataEntity(CustomerDataEntity customerDataEntity) {
        this.customerDataEntity = customerDataEntity;
    }

    public List<ItemModelEntity> getItems() {
        return Items;
    }

    public void setItems(List<ItemModelEntity> items) {
        Items = items;
    }
}
