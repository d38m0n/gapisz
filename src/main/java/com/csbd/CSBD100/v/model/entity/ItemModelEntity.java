package com.csbd.CSBD100.v.model.entity;

import com.csbd.CSBD100.v.model.enums.categorie.BasicUnit;
import com.csbd.CSBD100.v.model.enums.categorie.ItemKind;
import com.csbd.CSBD100.v.model.enums.categorie.Tax;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
    private String brandCode;
    private String fullName;
    private int workingTime;
    private String saleDate;
    private String expirationDate;
    private String paymentDate;
    private BasicUnit unit;
    private ItemKind itemKind;
    private String lengthOfWork;
    private String purchasePrice;
    private String salePrice;
    private Tax tax;

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

    public ItemModelEntity addUnit(BasicUnit unit) {
        this.unit = unit;
        return this;
    }

    public ItemModelEntity addItemKind(ItemKind itemKind) {
        this.itemKind = itemKind;
        return this;
    }

    public ItemModelEntity addLengthOfWork(String lengthOfWork) {
        this.lengthOfWork = lengthOfWork;
        return this;

    }

    public ItemModelEntity addPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public ItemModelEntity addTax(Tax tax) {
        this.tax = tax;
        return this;
    }

    public ItemModelEntity addSalePrice(String salePrice) {
        this.salePrice = salePrice;
        return this;
    }


    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getIdItem() {
        return idItem;
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

    public BasicUnit getUnit() {
        return unit;
    }

    public void setUnit(BasicUnit unit) {
        this.unit = unit;
    }

    public ItemKind getItemKind() {
        return itemKind;
    }

    public void setItemKind(ItemKind itemKind) {
        this.itemKind = itemKind;
    }

    public String getLengthOfWork() {
        return lengthOfWork;
    }

    public void setLengthOfWork(String lengthOfWork) {
        this.lengthOfWork = lengthOfWork;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }
}
