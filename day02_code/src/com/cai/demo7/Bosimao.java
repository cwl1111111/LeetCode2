package com.cai.demo7;

public class Bosimao extends Cats{
    public Bosimao() {
    }

    public Bosimao(String name, int age) {
        super(name, age);
    }

    @Override
    public void show() {
        System.out.println(getName()+"zai"+getAge());
    }
}
