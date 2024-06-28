package com.cai.demo4;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("xiaogou",1);
        dog.eat();
        dog.drink();

        Frog frog = new Frog("xiaowa",1);
        frog.eat();
        frog.drink();
        dog.swim();

    }
}
