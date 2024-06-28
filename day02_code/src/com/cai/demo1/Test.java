package com.cai.demo1;

import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("ss");
//        int a = scanner.nextInt();
//        String stra = "" + a;
//        int num =1;
//        while(a/10 !=0){
//            num++;
//            a/=10;
//        }
//        System.out.print(num);
//        for (int i = 0,j = num-1; i < j; i++, j--) {
//            if(stra.charAt(i) != stra.charAt(j)){
//                System.out.print("不是");
//                return;
//            }
//        }
//        System.out.print("是");
//    }
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        while(a>0){
            int b = (a%7==0 || a%10==7 || a/10%10==7) ? 0 : a;
            System.out.println(b);
            a--;
        }

    Random r = new Random();
    int number = r.nextInt(100)+1;
    Scanner sr = new Scanner(System.in);
    int c = sr.nextInt();
    if (c > number){
        System.out.println("dale");
    }
    }
}
