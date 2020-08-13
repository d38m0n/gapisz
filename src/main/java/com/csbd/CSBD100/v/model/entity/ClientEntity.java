package com.csbd.CSBD100.v.model.entity;

import com.csbd.CSBD100.v.model.enums.categorie.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
        Double sumOfBuy = items.stream()
                .mapToDouble(ItemModelEntity::getSalePrice)
                .sum();


        return new DecimalFormat("#,##0.00").format(BigDecimal.valueOf(sumOfBuy));
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
    private List<ItemModelEntity> items = new ArrayList<>();

    public ClientEntity() {
    }

    public String getCreateData() {
        return createData;
    }

    public ClientEntity factoryClient(ClientEntity clientEntity) {
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
        this.sumOfBuy = "0";
        this.createData = new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date());
        return this;
    }

    public ClientEntity addItem(ItemModelEntity imd) {
        this.items.add(imd);
        return this;
    }

    public CustomerDataEntity getCustomerDataEntity() {
        return customerDataEntity;
    }

    public void setCustomerDataEntity(CustomerDataEntity customerDataEntity) {
        this.customerDataEntity = customerDataEntity;
    }

    public List<ItemModelEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemModelEntity> items) {
        this.items = items;
    }
}
