package com.cai.demo8;

public class GirlFriend {
    private String name;
    private int age;

    public GirlFriend() {
    }

    public GirlFriend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>40 || name.length()<2){
            throw new NameException("name有误");
        }
        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        if(age<18||age>40){
            throw new AgeException("age格式有误");
        }
        this.age = age;
    }
}
