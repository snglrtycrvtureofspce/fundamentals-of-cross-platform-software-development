package com.example.domain;

public class Firma {

    public String name;

    public Firma() {
        name = "Samsung";
    }
    public Firma(String name) {
        this.name = name;
    }
    public void getName(String name) {
        this.name = name;
    }
    public String setName() {
        return this.name;
    }
}
