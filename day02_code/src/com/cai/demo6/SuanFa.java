package com.cai.demo6;

import java.util.Scanner;

public class SuanFa {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        test6(arr,0,5);
        for (int i : arr) {
            System.out.println(i);
        }

    }
    public static void test1(){
        int[] arr = {1,5,9,78,88,150,660};
        Scanner sr = new Scanner(System.in);
        int num = sr.nextInt();
        int a = 0;
        int b = arr.length-1;
        int c = 0;
        while(true){
            c = (a+b)/2;
            if(num<arr[c]){
                b = c-1;
            } else if (num>arr[c]) {
                a = c+1;

            }else if (num==arr[c]) {
                System.out.println(c);
                break;
            }
            if(a>b){
                System.out.println("?");
                break;
            }

        }
    }
    public static void test2(){
        int[] arr = {1,5,552,478,1,2,8,1,2,68,1,5,9,45,7};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i -1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void test3(){
        int[] arr = {1,5,552,478,1,2,8,1,2,68,1,5,9,45,7};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
            }
        }}
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void test4(){      //插入排序
        int startNum =-1;
        int[] arr = {1,5,552,478,1,2,8,1,2,68,1,5,9,45,7};
        for (int i = 0; i < arr.length-1; i++) {      //找到不顺序的第一个节点
            if(arr[i]>arr[i+1]){
                startNum = i+1;
                break;
            }
        }
        for (int i = startNum; i < arr.length; i++) {
            int j = i;
            while(j>0 && arr[j] < arr[j-1]){            //如果前面的数比他大，则交换位置
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int test5(int number){
        if (number ==1){
            return 1;
        } else  {
            return number+test5(number-1);

        }
    }
    public static void test6(int[] arr, int left, int right) { //快速排序

        if(left>right){
            return;
        }
        int start = left;
        int end = right;
        int centre = left;

        while(start<end){
            while(arr[end]>=arr[centre]&&start<end){
                end--;
            }
            while(arr[start]<=arr[centre]&&start<end){
                start++;
            }
        if(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;}

        }
        int temp = arr[centre];
        arr[centre] = arr[end];
        arr[end] = temp;

        test6(arr,left,end-1);    //此时end已经到了中间
        test6(arr,end+1,right);


    }


}
