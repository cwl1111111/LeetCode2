package com.cai.demo1;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
//        test1(arr);
//        int[] array2 = test2(arr,3,7);
//        for (int i = 0; i < array2.length; i++) {
//            System.out.println(array2[i]);
//        }
        int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
        test3(arr1);

    }
    public static void test1(int[] array){
        int a=0;
        for (int i = 0; i < array.length; i++) {
            a = a>array[i]?a:array[i];
        }
        System.out.println(a);
    }
    public static int[] test2(int[] array, int from, int to){
        int index = 0;
        int[] temp = new int[to-from];
        for (int i = from; i < to; i++) {
            temp[index++] = array[i];
        }
        return temp;
    }
    public static int test3(int[][] array){
        int sum2=0;
        for (int i = 0; i < array.length; i++) {
            int sum1 =0;
            for (int j = 0; j < array[i].length; j++) {
                sum1 +=array[i][j];
            }
            System.out.println(sum1);
            sum2+=sum1;
        }
        System.out.println(sum2);
        return 0;
    }
}
