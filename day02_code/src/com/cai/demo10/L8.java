package com.cai.demo10;

import java.util.*;

public class L8 {
    public static void main(String[] args) {
        reverseWords();
    }
    public static int removeDuplicates() {
        int[] nums={0,0,1,1,0,0,0,0,0,1,1,1,1,2,3,3};
        int slow=2;
        int fast=2;
        while(fast<nums.length){
            if(nums[slow-2]!=nums[fast]){           //当前 fast 指向的元素是否与 slow 前两个位置的元素相同，若不一致则给slow，若一致则继续找，fast+1
                nums[slow++] = nums[fast];             //与前两位元素比是关键，不是与slow比
            }
            fast++;
        }
        for (int num : nums) {
            System.out.println(num);
        }
        return 3;
    }
    public static void rotate() {
        int[] nums={1,2,3};
        int k=2;
        int len = nums.length;
        int actualMove = k%len;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int round = 0;
        while(round<actualMove){
            list1.add(nums[len-1-round]);
            round++;
        }
        for (int i = len-1; i >= actualMove; i--) {
            nums[i] = nums[i-actualMove];
        }

        list2 = list1.subList(0,actualMove);
        for (int i = 0; i < actualMove; i++) {
            nums[i] = list2.removeLast();
        }
        for (int num : nums) {
            System.out.println(num);
        }


    }
    public static void rotate2() {
        int[] nums = {1,2};
        int k = 3;
        int len = nums.length;
        int actualMove = k % len;
        int[] nums2 = new int[actualMove];
        int j = 0;
        for (int i = len-actualMove; i < nums.length; i++) {
            nums2[j] = nums[i];
            j++;
        }
        for (int i = len - 1; i >= actualMove; i--) {
            nums[i] = nums[i - actualMove];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[i] = nums2[i];
        }
        for (int num : nums) {
            System.out.println(num);
        }


    }
    public static int maxProfit() {
        int[] prices={7,1,5,3,6,4};
        int moneyMax = 0;
        int min = prices[0];
        for (int i =0;i < prices.length;i++) {
           min =  Math.min(min,prices[i]);
           moneyMax = Math.max(moneyMax,prices[i]-min);
        }
        System.out.println(moneyMax);
        return moneyMax;


        }

    public static int maxProfit2() {
        int[] prices={7,1,5,3,6,4};
        int money = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                money=money+prices[i]-prices[i-1];
            }
        }
        System.out.println(money);
        return money;
    }

    public static boolean canJump() {
        int[] nums = {2, 3, 1, 1, 4};
        int mostRemove = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= mostRemove) {
                mostRemove = Math.max(nums[i] + i, mostRemove);
            } else {
                    return false;
            }
        }
        return true;
    }

    public static int jump() {
        int[] nums={2,3,1,1,4};
        int maxDistance=0;
        int border=0;
        int step=0;
        for (int i = 0; i < nums.length-1; i++) {
            maxDistance=Math.max(maxDistance,i+nums[i]);
            if(i==border){
                border = maxDistance;
                step++;
            }
        }
        System.out.println(step);
        return step;
    }

    public static int canCompleteCircuit() {
        int[] gas={4,5,2,6,5,3};
        int[] cost={3,2,7,3,2,9};


        for (int j = 0; j < gas.length; j++) {
            int count=0;
            int gasValue=gas[j];
            for (int i = j; i < j+gas.length; i++) {
                if(i>gas.length-1){
                    i-=gas.length;
                }
                gasValue=gasValue - cost[i];
                if(gasValue>=0){
                    if(i==gas.length-1){
                        gasValue+=gas[0];
                    }else{
                        gasValue+=gas[i+1];
                    }
                    count++;

                }else{
                    break;
                }
                if(count==gas.length){
                    System.out.println(j);
                    return j;
                }
            }
        }
        System.out.println("-1");
        return -1;
    }
    public static int trap() {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int sum=0;
        int[] L = new int[height.length];
        int[] R = new int[height.length];
        int max1=0;
        for (int i = 0; i < height.length; i++) {
            max1=Math.max(height[i],max1);
            L[i] = max1;
        }
        int max2=0;

        for (int i =  height.length-1; i >=0; i--) {
            max2=Math.max(height[i],max2);
            R[i] = max2;
        }
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(L[i], R[i])-height[i];
            sum+=min;
        }
        return sum;

    }
    public static int romanToInt() {
        String s ="IV";
        int sum=0;
        Map<Character,Integer> map = new HashMap<>(){
            { put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);}
        };
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if(i<s.length()-1&&value<map.get(s.charAt(i+1))){
                value=-value;
            }
            sum+=value;
        }
        System.out.println(sum);
        return sum;
    }
    public static int lengthOfLastWord() {
        String s="Hello   World   s  sss    ";
        int count=0;
        for (int i = s.length()-1; i >=0; i--) {
            if(!(s.charAt(i)+"").equals(" ")){
                if(i>0&&(s.charAt(i-1)+"").equals(" ")){
                    count++;
                    break;
                }
                count++;
            }
        }

        return count;
    }
    public static String longestCommonPrefix() {
        String[] strs={"flower","flow","flight"};
        int minLen= Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen,str.length());
        }
        for (int i = minLen-1; i >=0; i--) {
            for (int j = 0; j < strs.length; j++) {
                String tempString = strs[j].substring(0,i+1);
                if(j>0&&!tempString.equals(strs[j-1].substring(0,i+1)) ){
                    break;
                }else{
                    if(j==strs.length-1){
                        System.out.println(strs[0].substring(0,i+1));
                        return strs[0].substring(0,i+1);
                    }
                }
            }
        }
        return "";
    }

    public static String reverseWords() {
        String s="  hello world  ";
        s = s.trim();              //关键
//        StringBuilder sb = new StringBuilder();
//        int len=s.length();
//        int i=0;
        String[] split = s.replaceAll("\\s+", ",").split(",");    //关键，将string通过正则表达式替换为一个字符，在用其分成数组。
        List<String> list = new ArrayList<>(List.of(split));
        Collections.reverse(list);
        String join = String.join(" ", list);
        System.out.println(join);
//        for (int i1 = split.length-1; i1 >=0; i1--) {
//            if(split[i1]!=null&&i1!=0){
//                sb.append(split[i1]).append(" ");
//            }else{
//                sb.append(split[i1]) ;
//            }
//        }
//        String string = sb.toString();
//        if(string.charAt(string.length()-1)==' '){
//            return string.substring(0,string.length()-1);
//        }
        return "";
    }

}
