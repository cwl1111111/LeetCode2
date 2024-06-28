package com.cai.demo1;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        int sum = 0;
        int [] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int private_num = sum/(array.length);
        System.out.println(sum);
        System.out.println(private_num);
    }
    public static int getSum(){
        return 0;
    }
}
