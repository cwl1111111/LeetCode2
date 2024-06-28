package com.cai.demo4;

public abstract class Animals {
    String name;
    int age;
    static {
        System.out.println("dongwu");
    }
    public Animals() {
    }

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat();

    public void drink(){
        System.out.println("heshui");
    };

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Animals{name = " + name + ", age = " + age + "}";
    }
}
