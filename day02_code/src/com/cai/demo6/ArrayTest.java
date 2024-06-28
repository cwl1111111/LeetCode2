package com.cai.demo6;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        test1();


    }

    public static void test1(){
        Girl g = new Girl("aeq",12);
        Girl g1 = new Girl("ss1",12);
        Girl g2 = new Girl("ss2",12);
        Girl[] grilArry = {g,g1,g2};
        Arrays.sort(grilArry,(o1, o2) -> {
            int d = o1.age-o2.age;
            d = o1.age-o2.age==0 ? o1.name.compareTo(o2.name) : d;     //如果年龄一样则用compare比较名字 此时d为Ascella差值
            return d;
        });
        for (int i = 0; i < grilArry.length; i++) {
            System.out.println(grilArry[i].name);
        }

    }
    public static void test2(){
        Integer[] arr = {1,54,4,8,9,6,4,3};

        Arrays.sort(arr,(o1,o2)-> o2-o1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}


class Girl{
    String name;
    int age;

    public Girl() {
    }

    public Girl(String name, int age ) {
        this.name = name;
        this.age = age;

    }
}
