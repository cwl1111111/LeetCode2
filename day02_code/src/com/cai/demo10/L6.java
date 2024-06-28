package com.cai.demo10;

import java.util.*;

public class L6 {
    public static void main(String[] args) {
        maxArea2();
    }
    public static int[] twoSum() {
        int[] nums = {3,2,4};
        int target = 6;
        int[] num12 = {};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums) {
            arrayList.add(num);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            int index = arrayList.indexOf(target-arrayList.get(i));
            if(index>=0&&index!=i){
                int[] nums2 = {i,index};
                return nums2;
            }
        }
        return num12;
    }

    public static List<List<String>> groupAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        HashMap<Integer,List<String>> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>(List.of(strs));
        ArrayList<Integer> arrayList = new ArrayList<>();

            for (String s : list) {
                int value=0;
                for (int i = 0; i < s.length(); i++) {
                value+= s.charAt(i);

            }
                arrayList.add(value);
        }
            for (int i = 0; i < arrayList.size(); i++) {
                List<String> list2 = new ArrayList<>();
                list2.add(list.get(i));
                for (int j = i+1; j < arrayList.size(); j++) {
                    if(arrayList.get(i).equals(arrayList.get(j))){
                        list2.add(list.get(j));
                    }
                }
                if(!hashMap.containsKey(arrayList.get(i))){
                    hashMap.put(arrayList.get(i),list2);
                }

            }
         List<List<String>> strList = new ArrayList<>();
        Set<Map.Entry<Integer, List<String>>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, List<String>> entry : entries) {
            strList.add(entry.getValue());
        }
        return strList;

    }
    public static List<List<String>> groupAnagrams1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String,List<String>> map = new HashMap<>();

        for (String str : strs) {
            List<String> stringList = new ArrayList<>();
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.put(key,stringList);
        }
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            if(map.containsKey(new String(arr))){
                map.get(new String(arr)).add(str);
            }
        }

        return new ArrayList<List<String>>(map.values());


    }
    public static int longestConsecutive() {
        int[] nums ={9,1,4,7,3,-1,0,5,8,-1,6};
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if(set.size()==1){
            return 1;
        }
        if(set.size()==0){
            return 0;
        }

        Integer[] array = set.stream().sorted().toArray(Integer[]::new);

        int slow=0;
        int fast=1;
        int temp=0;
        int count=1;
        while(fast<array.length){
            if(array[slow]+1==array[fast]){
                count++;
            }else{
                count=1;
            }
            if(count>temp){
                temp=count;

            }
            slow++;
            fast++;
        }
        System.out.println(temp);
        return temp;
    }
    public static void moveZeroes1() {
        int[] nums ={0,0,1};
        int right = nums.length-1;
        for (int i = 0; i < right; i++) {
            while(nums[right]==0){
                    right--;
            }
            if(nums[i]==0){
                int temp = nums[i];
                nums[i]  = nums[right];
                nums[right] = temp;
                right--;
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
//        int[] ints = list.stream().mapToInt(x -> x).toArray();   //将list转为数组
    }
    public static void moveZeroes2() {
        int[] nums ={0,1,0,3,12};
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[slow] = nums[i];
                slow++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i]=0;
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static int maxArea1() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxV = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int v = 0;
                int min = Math.min(height[i], height[j]);
                v = min  * (j - i);
                maxV = Math.max(v, maxV);
            }
        }
        System.out.println(maxV);
        return maxV;
    }
    public static int maxArea2() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int left = 0;
        int right = height.length-1;
        int maxV=0;
        while(left<right){
            int v = Math.min(height[left],height[right])*(right-left);
            maxV = Math.max(v,maxV);
            if(height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
        }
        System.out.println(maxV);
        return maxV;
    }
}
