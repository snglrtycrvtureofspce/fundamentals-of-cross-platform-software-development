package com.example.domain;

public class Cylinder_volume extends Figure {
    int _r, _h;
    public Cylinder_volume (String name, int r, int h) {
        super(name);
        this._r = r;
        this._h = h;
    }
    public double Volume () {
        return Math.PI * Math.pow(_r, 2) * _h;
    }
}
