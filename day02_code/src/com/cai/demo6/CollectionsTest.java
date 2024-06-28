package com.cai.demo6;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>() ;
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,"asd","asdwwade","wfgfag");    //Collections是集合的工具类
        Collections.shuffle(arrayList);                                         //打乱集合
        Collections.addAll(collection,"wdasd","wrwra");
        Collections.shuffle((ArrayList)collection);



        ArrayList<String> arrS1 = new ArrayList<>();
        ArrayList<String> arrS2 = new ArrayList<>();
        ArrayList<String> arrS3 = new ArrayList<>();
        Collections.addAll(arrS1,"najing","jiangsu","zhejiang");
        Collections.addAll(arrS2,"wqe","qwe","qw");
        Collections.addAll(arrS3,"we","e","rr");

        HashMap<String , ArrayList<String>> hm = new HashMap<>();
        hm.put("jiangsu",arrS1);
        hm.put("a",arrS2);
        hm.put("s",arrS3);

        

        hm.forEach((key,value)->{                                                       //两种方法
            StringJoiner stringJoiner = new StringJoiner(", ");
            for (String s : value) {
                stringJoiner.add(s);
            }
            System.out.println(key+":"+stringJoiner);
            return;

        });




        Set<Map.Entry<String, ArrayList<String>>> entries = hm.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {       //利用StringJoiner拼接 增强for中遍历的value字符串。
            StringJoiner sj = new StringJoiner(", ");
            for (String s : entry.getValue()) {
                sj.add(s);                         //把每个值都用“，”拼接
            }

            System.out.println(entry.getKey()+":"+sj);
        }



    }
}
