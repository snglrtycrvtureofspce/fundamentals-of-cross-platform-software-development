package com.example.domain;

public class Square extends Figure { // квадрат
    int _a, _b, _c, _d;
    public Square(String name, int a, int b, int c, int d) {
        super(name);
        this._a = a;
        this._b = b;
        this._c = c;
        this._d = d;
    }
    public int Sum () {
        return _a + _b + _c + _d;
    }
}
