package com.csbd.CSBD100.v.model.entity;

import com.csbd.CSBD100.v.model.enums.categorie.Status;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    private String status;
    private String privatePersonID;
    private String createData;
    private String sumOfBuy;

    public String getSumOfBuy() {
        return sumOfBuy;
    }

    public void setSumOfBuy(String sumOfBuy) {
        this.sumOfBuy = sumOfBuy;
    }

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private CustomerDataEntity customerDataEntity;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "client_item",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<ItemModelEntity> Items = new ArrayList<>();

    public ClientEntity() {
    }

    public String getCreateData() {
        return createData;
    }

    public ClientEntity factoryClient (ClientEntity clientEntity){
             this.privatePersonID = clientEntity.getPrivatePersonID();
             return this;
     }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public ClientEntity setAutoCreate(String privatePersonID) {

        this.privatePersonID = privatePersonID;
        this.setStatus(Status.NOWY.name());
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = new Date();
        this.sumOfBuy = "0";
        this.createData = df.format(date);
        return this;
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
