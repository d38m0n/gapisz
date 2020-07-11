package com.csbd.CSBD100.v.model.enums.categorie;

public enum BasicUnit {
    NONE,
    HOUR,
    KILOGRAM,
    LITER,
    PACKAGE,
    ART,
    SERVICE;

    public static BasicUnit getEnum(String numberUnit) {
        int choice = Integer.valueOf(numberUnit);
        BasicUnit basicUnit;
        switch (choice) {
            case 1:
                basicUnit = BasicUnit.HOUR;
                break;
            case 2:
                basicUnit = BasicUnit.KILOGRAM;
                break;
            case 3:
                basicUnit = BasicUnit.LITER;
                break;
            case 4:
                basicUnit = BasicUnit.PACKAGE;
                break;
            case 5:
                basicUnit = BasicUnit.ART;
                break;
            case 6:
                basicUnit = BasicUnit.SERVICE;
                break;
            default:
                basicUnit = BasicUnit.NONE;
                break;
        }
        return basicUnit;
    }
}
