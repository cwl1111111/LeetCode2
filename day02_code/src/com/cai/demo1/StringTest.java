package com.cai.demo1;

import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {
        test5();
    }
    public static void test1(){
        int num1=0,num2=0,num3=0;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(str.charAt(i));
            if(str.charAt(i) >=65 && str.charAt(i) <=90){
                num1++;
            }else if(str.charAt(i) >=97 && str.charAt(i)<=122){
                num2++;
            }else if(str.charAt(i) >=48 && str.charAt(i)<=57){
                num3++;
            }
        }

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }
    public static void test2(){
        // 注意 字符串本身不能发生变化
        String str1 = "123abc";
        System.out.println(str1.charAt(0)+0);    //查看“1”的ASCII表，通过表中对应的int类型的数字来判断。str1.charAt(0)+0 计算中str1.charAt(0)会转化为int，结果为int
        System.out.println(str1.charAt(0)-48);
        String[] arr = {"12","ab"};
        for (int i = 0; i < arr.length; i++) {
            str1 = str1.replace(arr[i],"**");
        }
        System.out.println(str1);
    }
    public  static void test3(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = new StringBuilder(str).reverse().toString();
        System.out.println(s);
    }
    public  static void test4(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str.length());
        String[] array = {" ","I","II"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(array[str.charAt(i)-48]);
        }
        System.out.println(sb.toString());

    }
    public  static void test5(){
        Scanner sr = new Scanner(System.in);
        String str1 = sr.nextLine();
        System.out.println();
        Scanner sr2 = new Scanner(System.in);
        String str2 = sr2.nextLine();
        StringBuilder sb = new StringBuilder(str1);
        int index = 0;
        while(true){
            sb.append(str1.charAt(0));
            sb.delete(0,1);
            str1 = sb.toString();
            if(str1.equals(str2)){
                System.out.println("111");
                break;
            }
            if(index>str1.length()){
                System.out.println("222");
                break;
            }
            index++;
        }

    }
}
