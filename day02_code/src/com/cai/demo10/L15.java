package com.cai.demo10;

import java.util.*;

public class L15 {
    public static void main(String[] args) {
        change();
    }



    public static int maxSubArray() {
        int[] nums = {5,-3,5};
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum+=nums[i];
            if(nums[i-1]>0){
                nums[i]+=nums[i-1];
            }
            max = Math.max(max,nums[i]);
        }
        int min = 0;
        for(int i = 1 ; i < nums1.length-1; i++){
            if(nums1[i-1]<0){
                nums1[i]+=nums1[i-1];
            }

            min = Math.min(min,nums1[i]);
        }
        return Math.max(sum-min,max);

    }
    public static boolean searchMatrix() {
        return true;
    }
    public static void kSmallestPairs() {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(2, (o1, o2) -> {
            int sum1 = o1.get(0) + o1.get(1);
            int sum2 = o2.get(0) + o2.get(1);
            return sum1 - sum2;
        });List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list3.add(2);
        list3.add(3);
        list2.add(1);
        list2.add(5);
        list4.add(2);
        list4.add(5);

        pq.add(list1);
        pq.add(list3);
        pq.add(list4);
        pq.add(list2);
        for (List<Integer> list : pq) {
        }
        int[] arr = {1,2};

        return ;
    }
    public static void test2(){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(3);
        medianFinder.addNum(6);
        medianFinder.addNum(4);
        medianFinder.addNum(3);
        medianFinder.addNum(6);
        medianFinder.addNum(1);
        medianFinder.addNum(3);

    }
    public static String addBinary() {
        String a="1111" ;
        String b="10";
        int i1 = Integer.parseInt(a, 2);
        StringBuilder sb = new StringBuilder();
        int ten = 0;
        int n1 = a.length();
        int n2 = b.length();
        StringBuilder num1 = new StringBuilder(a);
        StringBuilder num2 = new StringBuilder(b);

        int n = n1>n2 ? n1:n2;
        for(int i = 0 ; i < n; i++){
            int number1 = n1 > 0 ? num1.charAt(n1-1)-'0':0;
            int number2 = n2 > 0 ? num2.charAt(n2-1)-'0':0;
            n1--;
            n2--;
            int sum = 0;
            if(number1+number2+ten==2){
                sum = 0;
                ten = 1;
            }
            else if(number1+number2+ten==3){
                sum = 1;
                ten = 1;
            }
            else{
                sum = number1+number2+ten;
                ten=0;
            }
            sb.append(sum);
        }
        if(ten==1){
            sb.append(1);
        }
        StringBuilder reverse = sb.reverse();
        return reverse.toString();
    }
    public static int reverseBits() {

        StringBuilder sb = new StringBuilder("11111111111111111111111111111101");
        StringBuilder reverse = sb.reverse();

        System.out.println(Integer.parseInt(reverse.toString(), 10));
        return Integer.parseInt(reverse.toString(),10);
    }
    public static int hammingWeight() {
        int n = 128;
        int length = 32;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = length-1; i>=0;i--){
            count = ((n>>i) &1) ==1 ? count+1:count;
        }
        return count;
    }
    public static int singleNumber() {
        int[] nums = {1,1,-2,3,4,4,3,5,5,2,2,1,1};
        int k = 0;
        for(int i = 0 ; i < nums.length; i++){
            k = k^nums[i];
            System.out.println(k);
        }
        return k;
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(set.contains(nums[i])){
//                set.remove(nums[i]);
//            }else{
//                set.add(nums[i]);
//            }
//        }
//        int res = 0;
//        for (Integer i : set) {
//
//            res = i;
//        }
//
//        return res;
    }
    public static int singleNumber2() {
        int[] nums = {3,3,3,1};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue()==1) {
                return integerIntegerEntry.getKey();
            }
        }
        return 0;
    }
    public static int rangeBitwiseAnd() {
        int left=5;
        int right=7;
        if(left==right){
            return 0;
        }
        String s = "sss";
        StringBuilder sb = new StringBuilder(left+"");
        StringBuilder reverse = sb.reverse();
        int k = left;
        for(int i = left+1; i <=right; i++){
            k = k ^ i;
        }
        return k;
    }
    public static boolean isPalindrome() {
        int x = 10;
        if(x<0){
            return false;
        }

        int temp = x;
        int revertNum = 0;
        int beiShu =1;
        while(x!=0){

            revertNum = revertNum+x%10*beiShu;
            beiShu*=10;
            x/=10;
        }
        return revertNum==temp;
    }
    public static boolean wordBreak() {
        String s = "leetcode";

        List<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict, "leet", "code");

        int len = s.length();
        boolean[] arr = new boolean[len+1];
        arr[0] = true;
        StringBuilder sb = new StringBuilder(s);
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j]&&set.contains(sb.substring(j,i))){
                    arr[i] = true;
                }
            }
        }
        return arr[len];
    }
    public static int change() {
        int amount = 5;
        int[] coins = {1,2,5};
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0 ; i < coins.length; i++){
            for(int j = coins[i]; j<= amount; j++){
                dp[j] += dp[j-coins[i]];
            }
            
        }
        return dp[amount];
    }
}
