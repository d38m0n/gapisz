package com.csbd.CSBD100.v.model.enums.categorie;

public enum Activity {
    NONE(""),
    SERVICEMAN("Serviceman"),
    DEALER("Dealer"),
    TEACHER("Teacher"),
    OTHER("OTHER");
    private String name;

    Activity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
