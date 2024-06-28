package com.cai.demo6;

import java.util.ArrayList;
import java.util.Arrays;

public class FanXing <E>{
    private int size=0;
    Object[] obj = new Object[10];

    public boolean add(E e){

        obj[size] = e;
        size++;
        if(size==10){
            return false;
        }
        return true;
    }

    public void addAll(ArrayList<E> list, E e){
        list.add(e);
        list.add(e);
        list.add(e);
        list.add(e);
        System.out.println(list.toString());
    }
    public void addAll2(ArrayList<E> list, E...e){   //可变参数,本质为数组
        for (E element : e) {
            list.add(element);
        }
        System.out.println(list.toString());
    }

    public String toString(){
        System.out.println(Arrays.toString(obj));
        return Arrays.toString(obj);
    }
}

