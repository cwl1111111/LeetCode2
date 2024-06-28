package com.cai.demo7;

public abstract class Dogs extends Animals{
    public Dogs() {
    }

    public Dogs(String name, int age) {
        super(name, age);
    }
    @Override
    public abstract void show() ;
}
