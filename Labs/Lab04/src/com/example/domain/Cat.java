package com.example.domain;

public class Cat extends Animal implements Pet {
    public Cat(String name){
        super(name);
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void play() {
        System.out.println(this.name + " любит играть с веревочкой");
    }
    public void eat (){ System.out.println(this.name + " любит кушать"); }
    public void walk () { System.out.println(this.name + " любит ходить");}
}