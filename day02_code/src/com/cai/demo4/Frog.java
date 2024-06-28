package com.cai.demo4;

public class Frog extends Animals{
    static {
        System.out.println("wa");
    }
    public Frog() {
        super();
    }

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(getName()+"chichongzi");
    }

    @Override
    public void drink() {
        super.drink();
    }
}
