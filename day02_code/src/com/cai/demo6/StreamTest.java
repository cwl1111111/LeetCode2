package com.cai.demo6;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest{
    public static void main(String[] args) {

        ArrayList<String> arr = new ArrayList<>();
        arr.stream();


        HashMap<String,String> hm = new HashMap<>();
        hm.put("eqw","weq");
        Set<String> set = hm.keySet();
        set.stream().forEach((s)-> System.out.println(s)); //==set.forEach((s)-> System.out.println(s)) 但stream可以限制
        set.stream().filter(s->s.startsWith("e")).forEach(s-> System.out.println(s));
        Stream<String> stream1 =  set.stream().filter(s->s.startsWith("e"));   //只能用一次


        int[] a={1,5,5,478};
        Arrays.stream(a).forEach(s-> System.out.println(s));    //Arrays a = new Arrays(); 不对。arrays构造函数是私有的，

        Arrays.stream(a).filter(i->i!=5).forEach(s-> System.out.println(s));
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"weq-11","wqeq-11","sadsadad-11","2131s-11","adcxcxc-11","wewe-11","wewq222-11","weq222235-11");
        list.stream().map(s->Integer.parseInt(s.split("-")[1])).        //将字符串切割后转为转为int，传入s return int
                forEach(s-> System.out.println(s));

        list = list.stream().skip(3).limit(3).toList();  //跳过三个后取三个


        String[] stringArray = list.toArray(new String[list.size()]);    //List转为String
        long count = list.stream().skip(3).limit(3).count();
        for (String string : stringArray) {
            System.out.println(string);
        }

    }
}
