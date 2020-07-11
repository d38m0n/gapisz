package com.csbd.CSBD100.v.model.enums.categorie;

public enum Tax {
    NONE(0),
    EIGHT(8),
    TWENTY_THREE(23);
    private int tax;

    Tax(int tax) {
        this.tax = tax;
    }

    public int getTaxNumber() {
        return tax;
    }

    public static Tax getEnum (String taxNumber){
        int i = Integer.valueOf(taxNumber);
        Tax tax;
        switch (i){
            case 1:
                tax = Tax.EIGHT;
                break;
            case 2:
                tax = Tax.TWENTY_THREE;
                break;
            default:
                tax= Tax.NONE;
                break;
        }
        return tax;
    }
}
