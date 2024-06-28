package com.cai.demo4;

public class Dog extends Animals implements Swim{

    static {
        System.out.println("gou");
    }
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(getName()+"chigutou");
    }

    @Override
    public void drink() {
        super.drink();
    }

    @Override
    public void swim() {
        System.out.println("wozaiyouyong");
    }
}
