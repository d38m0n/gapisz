package com.csbd.CSBD100.v.model.entity;

import com.csbd.CSBD100.v.model.enums.categorie.Status;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private Status status;
    private String privatePersonID;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private CustomerData customerData;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "customer_item",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})

    private List<ItemModelEntity> Items = new ArrayList<>();

    public ClientEntity() {
    }

    public ClientEntity(String privatePersonID) {
        this.privatePersonID = privatePersonID;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getPrivatePersonID() {
        return privatePersonID;
    }

    public void setPrivatePersonID(String privatePersonID) {
        this.privatePersonID = privatePersonID;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

    public List<ItemModelEntity> getItems() {
        return Items;
    }

    public void setItems(List<ItemModelEntity> items) {
        Items = items;
    }
}
