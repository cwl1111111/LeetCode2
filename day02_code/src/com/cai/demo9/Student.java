package com.cai.demo9;

import java.io.Serial;
import java.io.Serializable;

//标记性接口，可以用序列化流序列化这个类
public class Student implements Serializable {


    @Serial
    private static final long serialVersionUID = -2685244913980484660L;
    private String name;
    private int age;
    private transient String address;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
