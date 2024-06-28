package com.cai.Duoxiancheng;

public class Threadtest {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        MyThread m3 = new MyThread();
        MyThread m4 = new MyThread();
        MyThread m5 = new MyThread();

        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
    }
}
