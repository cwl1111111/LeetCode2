package com.cai.demo10;

import java.util.*;

public class L9 {
    public static void main(String[] args) {
        spiralOrder();

    }
    public static String convert() {
        String s="AB";
        int numRows=1;
        if(s.length()>=numRows||numRows==1){
            return s;
        }
        int flag=1;
        int rowNum=0;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        for (int i = 0; i < s.length(); i++) {
            list.get(rowNum).append(s.charAt(i)+"");
            if(i>0&&i%(numRows-1)==0){                  //  核心是判断flag正负
                flag=-flag;
            }
            rowNum+=flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            sb.append(stringBuilder);
        }
        return sb.toString();

    }
    public static int strStr() {
        String haystack="sadbutsad";
        String needle="sad";
        return haystack.indexOf(needle);        //indexof返回索引
//        int count=0;
//        if(haystack.length()<needle.length()){
//            return -1;
//        }
//        for (int i = 0; i < haystack.length(); i++) {
//            if(haystack.charAt(i)==needle.charAt(0)){
//                for (int j = i; j < haystack.length(); j++) {
//                    if (haystack.charAt(j)==needle.charAt(count)) {
//                        count++;
//                    }else{
//                        count=0;
//                        break;
//                    }
//                    if(count==needle.length()){
//                        return i;
//                    }
//                }
//            }
//        }
//        return -1;
    }
    public static boolean isPalindrome() {
        String s = "ab_a";
        s = s.toUpperCase();

        String s1 = s.replaceAll("[\\W_]", "");
        System.out.println(s1);
        for (int i = 0,j=s1.length()-1; i < s1.length(); i++,j--) {
            if (s1.charAt(i)!=s1.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome2() {
        String s = "race a car";                            //StringBuilder提供了reverse
        s = s.toUpperCase();                                //字符串大写
        StringBuilder sb = new StringBuilder(s.replaceAll("[\\W_]", ""));
        if(sb.toString().equals(sb.reverse().toString())){         //reverse会改变stringbuilder，所以要后用
            return true;
        }else{
            return false;
        }

    }
    public static boolean isSubsequence() {
        String s="abc";
        String t ="ahbgdc";
        if(s.length()==0){
            return true;
        }
        if(s.length()>t.length()){
            return false;
        }
        int index=0;
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i)==s.charAt(index)){
                index++;
            }
            if(index==s.length()){
                return true;
            }
        }
        return false;

    }
    public static int[] twoSum() {
        int[] numbers={2,7,11,15};
        int target=9;
        int slow=0;
        int fast=numbers.length-1;
        int sum=0;
        while(slow<fast){
            sum=numbers[slow]+numbers[fast];
            if(sum<target){
                slow++;
            } else if (sum>target) {
                fast--;
            }else{
                return new int[]{slow+1, fast+1};
            }
        }
        return new int[]{};
    }
    public static int maxArea() {
        int[] height={};
        int maxValue=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            maxValue=Math.max(maxValue,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxValue;
    }

    public static List<List<Integer>> threeSum() {
        int[] nums={-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int slow=i+1;
            int fast=nums.length-1;
            while(slow<fast){
                int sum =nums[slow]+nums[fast]+nums[i];
                if(sum==0){
                        list.add(new ArrayList<>(Arrays.asList(nums[slow], nums[fast], nums[i])));
                        while(slow<fast&&nums[slow]==nums[slow+1]){
                            slow++;
                        }
                        while(slow<fast&&nums[fast]==nums[fast-1]){
                            fast--;
                        }

                    fast--;
                    slow++;
                }
                else if(sum<0){
                    slow++;
                }else{
                    fast--;
                }
            }

        }
        return list;
    }
    public static int minSubArrayLen() {
        int target=7;
        int[] nums={2,3,1,2,4,3};
        int len = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum =0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if(sum>=target){
                    len = Math.min(len,j-i+1);
                    break;
                }

            }
        }
        if(len == Integer.MAX_VALUE){
            return 0;
        }
        return len;
    }
    public static int minSubArrayLen2() {
        int target = 7;                                             //求子序列，一般都用滑块。
        int[] nums = {2,3,1,2,4,3};
        int sum=0;
        int left=0;
        int len=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum>=target){                                      //当遍历到的值大于target时，看看能否缩小左侧值
                while(left<i&&(sum-nums[left])>=target){           //关键，如果sum减去left的值还是大于等于target，则可以舍弃，同时left++，一直循环，知道left到达最大，使滑块内数量最小
                    sum-=nums[left];
                    left++;
                }
                len=Math.min(i-left+1,len);
            }
        }
        if(len==Integer.MAX_VALUE){
            return 0;
        }
        System.out.println(len);
        return len;
    }
    public static int lengthOfLongestSubstring() {
        String s="bbbbbb";
        int left=0;
        int len = 0;
        if(s.length()==1){
            return 1;
        }
        for (int i = 1; i < s.length(); i++) {
            while(left<i&&s.substring(left,i).contains(s.charAt(i)+"")){  //关键,如果前面的string含有遍历到的i，循环，直到把这个数移出滑块。
                left++;
            }
            len = Math.max(len,i-left+1);
        }
        System.out.println(len);
        return len;
    }
    public static List<Integer> findSubstring() {
        String s="wordgoodgoodgoodbestword";
        String[] words={"word","good","best","good"};
        int wordLen = words[0].length();
        Map<String,Integer> map = new HashMap<>();              //无序就用hashmap来记录出现的数目。
        for (String word : words) {
            if(!map.containsKey(word)){
                map.put(word,1);
            }else{
                map.put(word,map.get(word)+1);
            }
        }
        List<Integer> list = new ArrayList<>();
        int len = wordLen*words.length;
        if(len>s.length()){
            return list;
        }
        for (int i = 0; i <= s.length()-len; i++) {
            String substring = s.substring(i, i+len);
            Map<String,Integer> map2 = new HashMap<>();
            for (int j = 0; j <= substring.length()-wordLen; j+=wordLen) {
                String substring1 = substring.substring(j, j + wordLen);
                if(!map2.containsKey(substring1)){
                    map2.put(substring1,1);
                }else{
                    map2.put(substring1,map2.get(substring1)+1);
                }

            }
            if(map2.equals(map)){
                list.add(i);
            }

        }
        return list;
    }
    public static void minWindow() {
//        String s="ADOBECODEBANC";
//        String t="ABC";
//        String real = s;
//        Map<String,Integer> map = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            if(!map.containsKey(t.charAt(i)+"")){
//                map.put(t.charAt(i)+"",1);
//            }else{
//                map.put(t.charAt(i)+"",map.get(t.charAt(i)+"")+1);
//            }
//        }
//        int index=0;
//        Map<String,Integer> map2 = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if(map2.containsKey(s.charAt(i)+"")){
//                map2.put(s.charAt(i)+"",map2.get(s.charAt(i)+"")+1);
//            }
//            if(map.containsKey(s.charAt(i)+"")){
//                map2.put(s.charAt(i)+"",1);
//            }
//
//            if(map2.size()==map.size()){
//                while(!map.containsKey(s.charAt(index)+"")||map.get(s.charAt(index)+"")>1){   //index左移且保证滑块内必须有全部的字符。
//                    index++;
//                    if(map.containsKey(s.charAt(index)+"")){
//                        map.put(s.charAt(i)+"",map.get(s.charAt(i)+"")-1);
//                    }
//                }
//                String substring = s.substring(index, i);
//                if(substring.length()<real.length()){
//                    real = substring;
//                }
//
//            }
//        }
//        System.out.println(real);
//        return real;
    }
    public static List<Integer> spiralOrder() {
        int[][] matrix={{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = new ArrayList<>();
        int left=0;
        int right = matrix[0].length-1;
        int top=0;
        int bottom = matrix.length-1;
        while(left<=right&&top<=bottom){
            for (int i = left; i <= right ; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for (int i = right; i >=left ; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
           if(left<=right){
               for (int i = bottom; i >=top ; i--) {
                   list.add(matrix[i][left]);
               }
               left++;
           }
        }
        return list;
    }
}
