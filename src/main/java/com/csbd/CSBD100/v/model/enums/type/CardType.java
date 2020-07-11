package com.csbd.CSBD100.v.model.enums.type;

public enum CardType {
    OPEN (100.0),  CONCESSIONARY (79.0) , HALF_OPEN (55.0), THREE_MONTHS(270);
    private double prince;

    CardType(double prince) {
        this.prince = prince;
    }
}
