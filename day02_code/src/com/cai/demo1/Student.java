package com.cai.demo1;

public class Student {
    private String name;
    private int age;
    private int number;


    public Student() {
    }

    public Student(String name, int age, int number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }


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

    /**
     * 获取
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    public String toString() {

        return "Student{name = " + name + ", age = " + age + ", number = " + number + "}";
    }


}
