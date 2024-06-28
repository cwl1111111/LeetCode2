package com.cai.demo1;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Student[] array = new Student[3];

        Scanner scanner = new Scanner(System.in);

        int index = 0;
        int a = 0;
        while(a<3){
            Boolean isRepeat = false;
            System.out.println("请输入姓名,年龄和number");
            String name = scanner.next();
            int age = scanner.nextInt();
            int number = scanner.nextInt();
            for (int j = 0; j < a; j++) {
                if(number == array[j].getNumber()){
                    System.out.println("重复");
                    isRepeat = true;
                    break;
                }
            }
            if(isRepeat){
                continue;
            }

            array[a] = new Student(name, age, number);
            a++;
        }
        deleteStudent(array,123);

    for (int i = 0; i < array.length; i++) {
        if(array[i] == null){
            continue;
        }
        System.out.println(array[i].toString());
    }


    }

    public static String deleteStudent(Student[] array,int num){
        for (int i = 0; i < array.length; i++) {
            if(num == array[i].getNumber()){
                array[i] = null;

            }else{
                return "删除失败";
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null){
                continue;
            }
            System.out.println(array[i].toString());
        }

        return "删除成功";
    }


    public void select(Student[] array,int name){
        for (int i = 0; i < array.length; i++) {
            if(array[i].getName().equals(name)){
                array[i].setAge(array[i].getAge()+1);
            }
        }
    }
}
