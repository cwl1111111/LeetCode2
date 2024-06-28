package com.cai.demo6;

import java.util.*;

public class ListofTest {
    public static void main(String[] args) {
        List<String> list = List.of("asd","sad");  //创建不可变集合
        Set<String> str = Set.of("sa","asd","asd");

        Map<String,String> map = Map.of("zhangsan","lisi","wangwu","zhangliu");
        // 或
        HashMap<String,String> hm = new HashMap<>();
        hm.put("sda","sad");
        hm.put("wqe","asd");
        Map<String,String> map2 = Map.copyOf(hm);



    }
}
