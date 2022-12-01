package com.example.domain;

public abstract class Worker {
    String _name;
    public Worker (String name) {
        this._name = name;
    }
    public abstract double salary();
}