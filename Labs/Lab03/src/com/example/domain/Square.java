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

    public int get_a() {
        return _a;
    }

    public void set_a(int _a) {
        this._a = _a;
    }

    public int get_b() {
        return _b;
    }

    public void set_b(int _b) {
        this._b = _b;
    }

    public int get_c() {
        return _c;
    }

    public int get_d() {
        return _d;
    }

    public void set_d(int _d) {
        this._d = _d;
    }

    public void set_c(int _c) {
        this._c = _c;
    }

    public int Sum () {
        return this._a + this._b + this._c + this._d;
    }
}
