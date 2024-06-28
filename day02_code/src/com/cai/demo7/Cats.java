package com.cai.demo7;

public abstract class Cats extends Animals{


    public Cats() {
    }

    public Cats(String name, int age) {
        super(name, age);
    }
    @Override
    public abstract void show() ;
}
