package com.cai.demo6;

import java.util.*;

public class ForPlus {
    public static void main(String[] args) {
//        Collection<String> coll = new ArrayList<>();
//        coll.add("wang");
//        coll.add("was");
//        coll.add("wg");
//        coll.add("ang");
//
//
//        for (String s : coll) {                  //增强for
//            System.out.println(s);
//        }
//
//        Iterator<String> it = coll.iterator();  //迭代器
//        while (it.hasNext()){
//            String s = it.next();
//            System.out.println(s);
//        }
//
//        coll.forEach(s -> System.out.println(s));    //lambda表达式foreach
//

        Collection<String> collection = new ArrayList<>();
        List<String> list =  new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        list.add("wg");
        list.add("ss");
        list.add("aa");
        for (int i = 0; i < list.size(); i++) {      //此方法删除元素可能会报错，因为对列表改变后删除元素的后面的索引也会改变，
            if(list.get(i).equals("ss")){            // 每次删除后需要对i--，才能删除相同的两个元素，但多个相同元素就无法保证，或者从后往前遍历，所以用迭代器更保险
                list.remove(i);
            }
        }

        System.out.println(list.toString());
        ListIterator<String> listIterator = list.listIterator();   //列表迭代器,可以用add
        while(listIterator.hasNext()){
            String s = listIterator.next();
            if(s.equals("wg")){
                listIterator.add("sss");   //加到wg后面
            }
            System.out.println(s);
        }
        System.out.println(list.toString());


    }

}
