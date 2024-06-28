package com.cai.demo6;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        test4();
    }

    public static void test1(){
        Map<String,String> map = new HashMap<>();

        map.put("weq","awdas");
        map.put("q","wdas");
        map.put("qweweee","aasdsdwdas");

//        Set<String> strings = map.keySet();
//        for (String string : strings) {
//            String value = map.get(string);
//            System.out.println(value);
//        }
//
//        Iterator<String> it = strings.iterator();
//        while (it.hasNext()){
//            String value = map.get(it.next());
//            System.out.println(value);
//        }
//
//        strings.forEach(s->System.out.println(map.get(s)));


        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
            System.out.println(entry.getKey()+entry.getValue());
        }

        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println(iterator.next().getKey()+iterator.next().getValue());
        }

        entries.forEach(s-> System.out.println(s));
        entries.forEach(s-> System.out.println(s.getKey()));



        map.forEach((key, value)-> System.out.println(key+"="+value));   //直接用consumer的foreach  底层是增强for对entries遍历
    }
    public static  void test2(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A",0);
        hashMap.put("B",0);
        hashMap.put("C",0);
        hashMap.put("D",0);
        Random r = new Random();


        int choose;
        int A=0;
        int B=0;
        int C=0;
        int D=0;
        for (int i = 0; i < 80; i++) {
             choose = r.nextInt(0,4);
             switch (choose){
                 case 0 -> A++;
                 case 1 -> B++;
                 case 2 -> C++;
                 case 3 -> D++;
             }
        }
        hashMap.replace("A",A);
        hashMap.replace("B",B);
        hashMap.replace("C",C);
        hashMap.replace("D",D);

        hashMap.forEach((key,value)-> System.out.println(key+"="+value));


    }
    public static void test3(){
        Map<Integer, String> tm = new TreeMap<>();

    }

    public static void test4(){
        HashMap<Character, Integer> hm = new HashMap<>();

        String str = "aababcabcdabcde";

        for (int i = 0; i < str.length(); i++) {
            if(!hm.containsKey(str.charAt(i))){
                hm.put(str.charAt(i),0);
            }
            int value = hm.get(str.charAt(i));
            value++;
            hm.put(str.charAt(i),value);

        }
        hm.forEach((key,value)-> System.out.println(key+"="+value));

    }
}
