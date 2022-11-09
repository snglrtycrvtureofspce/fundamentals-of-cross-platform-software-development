package com.example.domain;

public class Figure {
    String _name;
    public Figure (String name){
        this._name = name;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
    public void display_into_name(){
        System.out.println("Имя: " + this._name);
    }
    public String getName (){ return this._name; }
}
