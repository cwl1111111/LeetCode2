package com.cai.demo1;

public class RoleTest1 {
    public static void main(String[] args) {
        Role role1 = new Role("小红",100);
        Role role2 = new Role("小名",100);
        while(true){
            role1.attack(role2);
            if(role2.getBlood()==0){
                System.out.println("小红赢了");
                break;
            }
            role2.attack(role1);
            if(role1.getBlood()==0){

                System.out.println("小名赢了");
                break;
            }

        }

    }
}
