package com.cai.demo2;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    String username;
    String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{username = " + username + ", password = " + password + "}";
    }


    public static void userMain(){
        boolean isSuccessful =false;
        ArrayList<User> userArrayList =  new ArrayList<>();
        while(true){
            Scanner sr = new Scanner(System.in);

            System.out.println("user");
            System.out.println("1.注册");
            System.out.println("2.登录");


            int choose = sr.nextInt();

            switch (choose){
                case 1 ->
                        addUser(userArrayList);
                case 2 ->
                        isSuccessful = userSignin(userArrayList);
                default -> System.out.println("无");

            }
            if(isSuccessful){
                break;
            }
        }

    }

    public static ArrayList<User> addUser(ArrayList<User> userArrayList){
        Scanner sr = new Scanner(System.in);
        System.out.println("请输入username");
        String username = sr.next();
        System.out.println("请输入password");
        String password = sr.next();
        User s = new User(username,password);
        userArrayList.add(s);

        System.out.println("添加成功");
        return userArrayList;
    }

    public static boolean userSignin(ArrayList<User> userArrayList){

        boolean isSuccessful=false;

        Scanner sr = new Scanner(System.in);
        System.out.println("输入用户名");
        String username = sr.next();

        System.out.println("输入密码");
        String password = sr.next();
        for (int i = 0; i < userArrayList.size(); i++) {
            if(username.equals(userArrayList.get(i).username )&& password.equals(userArrayList.get(i).password)){
                isSuccessful = true;
                System.out.println("验证成功");
                return isSuccessful;

            }
            System.out.println("验证失败");

        }


        return false;

    }

}
