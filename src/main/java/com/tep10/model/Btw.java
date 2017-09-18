package com.tep10.model;

/**
 * Created by UG34QP on 18-9-2017.
 */
public enum Btw {
    h ("btw hoog"),
    l ("btw laag"),
    v ("btw verlegt"),
    n ("btw nul");

    private String description;
    Btw(String description) {
        this.description = description;
    }
}
