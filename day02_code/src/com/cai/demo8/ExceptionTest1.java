package com.cai.demo8;

import java.util.Scanner;

public class ExceptionTest1 {
    public static void main(String[] args) {
        GirlFriend girlFriend = new GirlFriend();
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String age = "";
        while(true) {
            try {
                name = scanner.nextLine();
                age = scanner.nextLine();
                girlFriend.setName(name);
                girlFriend.setAge(Integer.parseInt(age));
                break;
            } catch (NumberFormatException e) {     //catch后不会停止程序运行
                e.printStackTrace();
            }
            catch (AgeException e){
                e.printStackTrace();
            }catch (NameException e){
                e.printStackTrace();
            }
        }
    }
}
