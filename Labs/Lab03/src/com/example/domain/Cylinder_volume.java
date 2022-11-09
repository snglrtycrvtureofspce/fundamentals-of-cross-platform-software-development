package com.example.domain;

public class Cylinder_volume extends Figure {
    int _r, _h;
    public Cylinder_volume (String name, int r, int h) {
        super(name);
        this._r = r;
        this._h = h;
    }

    public int get_h() {
        return _h;
    }

    public void set_h(int _h) {
        this._h = _h;
    }

    public int get_r() {
        return _r;
    }

    public void set_r(int _r) {
        this._r = _r;
    }

    public double Volume () {
        return Math.PI * Math.pow(this._r, 2) * this._h;
    }
}
