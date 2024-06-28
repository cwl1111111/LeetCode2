package com.cai.demo2;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void startStudentSystem(){
        ArrayList<Student> studentArrayList =  new ArrayList<>();
        while(true){
            Scanner sr = new Scanner(System.in);

            System.out.println("欢迎");
            System.out.println("1.添加");
            System.out.println("2.修改");
            System.out.println("3.展示");
            System.out.println("4.退出");


            int choose = sr.nextInt();

            switch (choose){
                case 1 ->
                        add(studentArrayList);
                case 2 ->
                        change(studentArrayList);
                case 3 ->
                        showInfor(studentArrayList);
                case 4 ->
                        exit();
                default -> System.out.println("无");

            }
        }

    }
    public static ArrayList<Student> add(ArrayList<Student> studentArrayList){
        Scanner sr = new Scanner(System.in);
        System.out.println("请输入id");
        int id = sr.nextInt();
        System.out.println("请输入name");
        String name = sr.next();
        System.out.println("请输入age");
        int age = sr.nextInt();
        System.out.println("请输入address");
        String address = sr.next();
        Student s = new Student(id,name,age,address);
        studentArrayList.add(s);
        System.out.println(studentArrayList.get(0).getId());
        return studentArrayList;
    }

    public static ArrayList<Student> change(ArrayList<Student> studentArrayList){
        System.out.println("你想修改的人id");
        Scanner sr = new Scanner(System.in);
        int id = sr.nextInt();
        for (int i = 0; i < studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getId()==id){
                System.out.println("请输入修改后的名字");
                String name = sr.next();

                studentArrayList.get(i).setName(name);
                System.out.println("成功");
                return studentArrayList;
            }

        }
        System.out.println("未找到");
        return studentArrayList;


    }
    public static void showInfor(ArrayList<Student> studentArrayList){
        System.out.println(studentArrayList);
    }
    public static void exit(){
        System.exit(0);
    }

}
