package com.csbd.CSBD100.v.model.enums.categorie;

public enum Tax {
    NONE(0.0),
    CREDIT(0.01),
    SELL(0.08),
    BUY(0.23);
    private Double tax;

    Tax(Double tax) {
        this.tax = tax;
    }

    public Double calculateTax(Double prince) {
        return tax * prince;
    }

    public Double calculateTax(Double prince, Double newTax) {
        tax = newTax;
        return calculateTax(prince);
    }

}
