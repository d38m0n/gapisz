package com.csbd.CSBD100.v.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class ItemModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateAddToMag;
    private String dataAddToClient;
    private String brandCode;
    private String fullName;
    private int workingTime;
    private String saleDate;
    private String expirationDate;
    private String paymentDate;
    private String unit;
    private String itemKind;
    private String lengthOfWork;
    private Double purchasePrice ;
    private Double salePrice;
    private String tax;
    private int amount;
    private boolean available;

    public void setDateAddToMag(String dateAddToMag) {
        this.dateAddToMag = dateAddToMag;
    }

    public void setDataAddToClient(String dataAddToClient) {
        this.dataAddToClient = dataAddToClient;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = true;
    }
    public void notAvailable() {
        this.available = false;
    }

    public ItemModelEntity setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public ItemModelEntity() {


    }


    public ItemModelEntity addBrandCode(String brandCode) {
        this.brandCode = brandCode;
        return this;
    }

    public ItemModelEntity addFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public ItemModelEntity addWorkTime(int workingTime) {
        this.workingTime = workingTime;
        return this;
    }

    public ItemModelEntity addSaleDate(String saleDate) {
        this.saleDate = saleDate;
        return this;
    }

    public ItemModelEntity addExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public ItemModelEntity addPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public ItemModelEntity addUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public ItemModelEntity addItemKind(String itemKind) {
        this.itemKind = itemKind;
        return this;
    }

    public ItemModelEntity addLengthOfWork(String lengthOfWork) {
        this.lengthOfWork = lengthOfWork;
        return this;

    }

    public ItemModelEntity addPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public ItemModelEntity addTax(String tax) {
        this.tax = tax;
        return this;
    }

    public ItemModelEntity addSalePrice(Double salePrice) {
        this.salePrice = salePrice;
        return this;
    }


    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getItemKind() {
        return itemKind;
    }

    public void setItemKind(String itemKind) {
        this.itemKind = itemKind;
    }

    public String getLengthOfWork() {
        return lengthOfWork;
    }

    public void setLengthOfWork(String lengthOfWork) {
        this.lengthOfWork = lengthOfWork;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getDateAddToMag() {
        return dateAddToMag;
    }

    public ItemModelEntity setDateAddToMag() {
        this.dateAddToMag = getDate();
        return this;
    }

    public String getDataAddToClient() {
        return dataAddToClient;
    }

    public ItemModelEntity setDataAddToClient() {
        this.dataAddToClient = getDate();
        return this;
    }

    private String getDate() {
        return new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date());
    }
}
