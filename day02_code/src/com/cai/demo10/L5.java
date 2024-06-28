package com.cai.demo10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class L5 {
    public static void main(String[] args) {
int[] nums = {};
        int num = nums.length/2;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            if(hashMap.containsKey(i)){
                hashMap.put(i,hashMap.get(i) + 1);
            }else{
                hashMap.put(i,1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue()>num){
                System.out.println(entry.getKey());

            }
        }
    }
}
