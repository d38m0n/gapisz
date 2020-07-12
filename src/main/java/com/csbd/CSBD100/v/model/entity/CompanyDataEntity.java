package com.csbd.CSBD100.v.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompanyDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompany;
    private int nip;
    private int regon;
    private String fullName;
    private String cityCompany;
    private String streetCompany;
    private String numberCompany;

    public CompanyDataEntity() {
      }

    public Long getIdCompany() {
        return idCompany;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public int getRegon() {
        return regon;
    }

    public void setRegon(int regon) {
        this.regon = regon;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCityCompany() {
        return cityCompany;
    }

    public void setCityCompany(String cityCompany) {
        this.cityCompany = cityCompany;
    }

    public String getStreetCompany() {
        return streetCompany;
    }

    public void setStreetCompany(String streetCompany) {
        this.streetCompany = streetCompany;
    }

    public String getNumberCompany() {
        return numberCompany;
    }

    public void setNumberCompany(String numberCompany) {
        this.numberCompany = numberCompany;
    }
}
