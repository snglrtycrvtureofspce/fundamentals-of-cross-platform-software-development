package com.example.domain;

public class Square_area extends Figure{
    int _a, _d;
    public Square_area (String name, int a, int d){
        super(name);
        this._a = a;
        this._d = d;
    }
    public double area () {
        return Math.pow(_d, 2) / 2;
    }
}
