package com.cai.demo10;

import java.util.*;

public class L11 {
    public static void main(String[] args) {

        summaryRanges2();
    }
    public static boolean containsNearbyDuplicate() {
        int[] nums={1,2,3,1,2,3};
        int k=2;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]&&j-i<=k){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean containsNearbyDuplicate2() {
        int[] nums={1,2,3,1,2,3};
        int k=2;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
                if(i-map.get(nums[i])<=k){
                    return true;
                }
                map.put(nums[i],i);
            }
        }
        return false;
    }
    public static int longestConsecutive() {
        int[] nums={4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        if(nums.length==0){
            return 0;
        }
        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);     //重点：将int数组转为Integer数组，再将其放入set集合，再转为数组，并排序
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        if(set.size()==1){
            return 1;
        }
        Integer[] array1 = set.stream().toArray(Integer[]::new);
        Arrays.sort(array1);
        int slow = 0;
        int fast = 1;
        int len=0;
        while(fast<array1.length){
            if(array1[fast]-1==array1[fast-1]+0||array1[fast]+0==array1[fast-1]+0){
                fast++;
            }else{
                fast++;
                slow=fast-1;
            }
            len=Math.max(len, fast-slow);
        }
        return len;
    }
    public static List<String> summaryRanges() {
        int[] nums={0,1,2,4,5,6};

//        if(nums.length==1){
//            return new ArrayList<>(Arrays.asList(Arrays.toString(nums)));             //将int数组变为List<String>
//        }

        List<String> list = new ArrayList<>();
        if(nums.length==0){
            return list;
        }
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        int slow=0;
        int fast=1;
        while(fast<nums.length){
            if(nums[fast]-1==nums[fast-1]){
                fast++;
            }else{
                if(nums[slow]==nums[fast-1]){
                    list.add(nums[slow]+"");
                }else{
                    list.add(nums[slow]+"->"+nums[fast-1]);
                }
                slow=fast;
                fast++;
            }
            if(fast==nums.length){
                if(nums[slow]==nums[fast-1]){
                    list.add(nums[slow]+"");
                }else{
                    list.add(nums[slow]+"->"+nums[fast-1]);
                }

            }
        }
        return list;
    }
    public static List<String> summaryRanges2() {
        int[] nums={0,1,2,3,4,5,6};
        int slow = 0;
        int fast= 1;
        List<String> list = new ArrayList<>();
        if(nums.length==0){
            return list;
        }
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        while(fast<nums.length){
            while(fast<nums.length&&nums[fast-1]==nums[fast]-1){ //满足条件快速移动指针
                fast++;
            }
            if(nums[fast-1]==nums[slow]){
                list.add(nums[slow]+"");
            }else{
                list.add(nums[slow]+"->"+nums[fast-1]);
            }
            slow=fast;
            fast++;
            if(fast==nums.length){
                if(nums[fast-1]==nums[slow]){
                    list.add(nums[slow]+"");
                }else{
                    list.add(nums[slow]+"->"+nums[fast-1]);
                }

            }
        }

        return list;
    }
}
