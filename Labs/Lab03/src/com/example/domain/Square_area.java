package com.example.domain;

public class Square_area extends Figure{
    int _a, _d;
    public Square_area (String name, int a, int d){
        super(name);
        this._a = a;
        this._d = d;
    }

    public int get_d() {
        return _d;
    }

    public void set_d(int _d) {
        this._d = _d;
    }

    public int get_a() {
        return _a;
    }

    public void set_a(int _a) {
        this._a = _a;
    }

    public double area () {
        return Math.pow(this._d, 2) / 2;
    }
    public void display_into_name(){
        super.display_into_name();
        System.out.println("Имя: " + this._a + "\t" + this._d);
    }
}
