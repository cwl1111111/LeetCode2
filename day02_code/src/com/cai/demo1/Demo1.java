package com.cai.demo1;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max1 = a > b ? a : b;
        int max2 = max1 > c ? max1 : c;
        System.out.println(max1 > max2 ? max1 : max2);
    }
}
