package com.cai.demo4;

import java.util.ArrayList;

public class AnimalList {
    private String name;
    private ArrayList<Animals> al;

    public AnimalList(){};

    public AnimalList(String name, ArrayList<Animals> al) {
        this.name = name;
        this.al = al;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Animals> getAl() {
        return al;
    }

    public void setAl(Animals animals) {
        al.add(animals);
    }
}
