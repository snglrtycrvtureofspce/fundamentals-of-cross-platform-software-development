package com.example.domain;

public class SwimPiggy extends Animal implements Pet{
    public SwimPiggy(String name){
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
        System.out.println(this.name + " Морская свинка играется");
    }

    @Override
    public void eat() {
        System.out.println(this.name + " Свинка кушает");
    }

    @Override
    public void walk() {
        System.out.println(this.name + " Свинка гуляет и бегает");
    }
}
