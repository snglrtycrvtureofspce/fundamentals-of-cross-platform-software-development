package com.example.domain;

public class Fish extends Animal implements Pet {
    public Fish(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    } @Override
    public void play() {
        System.out.println("Рыбка просто плавает");
    }

    public void eat() { System.out.println("Ем"); }

    public void walk() { System.out.println("Хожу"); }
}
