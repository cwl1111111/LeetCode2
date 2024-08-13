package com.cai.demo10;

import java.util.*;

public class L20 {
    public static void main(String[] args) {
        searchRange();

    }
    public static int coinChange() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int[] dp = new int[amount+1];
        for(int i = 0 ; i< amount+1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i = 0 ; i < coins.length; i++){
            for(int j = coins[i] ; j <=amount; j++){
                if(dp[j-coins[i]]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j-coins[i]]+1,dp[j]);
                }
            }
        }

        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
    public static boolean wordBreak() {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for(int i = 1 ; i <= len; i++){
            for(int j = i; j <= len; j++){
                if(dp[i-1]&&set.contains(s.substring(i-1,j))){
                    dp[j] = true;
                }
            }
        }

        return dp[len];

    }
    public static int rob() {
        int[] nums = {1,2,3,1};
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0],nums[1]);
        for(int i = 3; i <=n;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n];
    }
    public static int maxPoints() {
        int[][] points = {{2,3},{3,3},{-5,3}};
        int m = points.length;
        int max = 0;
        for(int i = 0 ; i < m-1 ; i++){
            Map<Double,Integer> map = new HashMap<>();
            int count = 1;
            for(int j = i+1; j < m ; j++){
                double k = 0;
                double x = points[j][0] - points[i][0];
                double y = points[j][1] - points[i][1];
                if(x ==0){
                     k = Double.MAX_VALUE;
                }else{
                     k = y/x;
                }
                if(Math.abs(k)==0) k=0;
                map.put(k,map.getOrDefault(k,0)+1);

            }
            for (Integer value : map.values()) {
                max = max>value? max:value;
            }

        }
        return max+1;
    }
    public static double myPow() {
        double x= 2.1000;
        int n = 3;
        double addition = 1;
        double x_x = x;
        while(n!=0){
            if(n!=1&&n%2!=0){
                addition*=x_x;
            }
            n/=2;
            if(n==0){
                break;
            }
            x*=x;

        }
        return x*addition;
    }
    public static int rangeBitwiseAnd() {
        int left = 10;
        int right =11;
        int i = 0;
        while(left!=right){
            left>>=1;
            right>>=1;
            i++;
        }
        return 0;
    }
    public static int hammingWeight() {
        int n = 11;
        int count = 0;

        for(int i = 31; i >=0; i--){
            System.out.println(n>>i);
            count+=(n >> i) & 1 ;
        }
        return count;
    }



    public static List<List<Integer>> kSmallestPairs() {
        int[] nums1 = {1,7,11};
        int[] nums2={2,4,6} ;
        int k = 3;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0]+o1[1]-o2[0]-o2[1]);
        bianLi(nums1,nums2,k,priorityQueue);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(Arrays.stream(priorityQueue.poll()).boxed().toList());
        }
        return list;
    }
    public static void bianLi(int[] nums1, int[] nums2, int k,PriorityQueue<int[]> priorityQueue){
        int n1 = nums1.length > k ? k : nums1.length;
        int n2 = nums2.length > k ? k : nums2.length;
        Set<int[]> set = new HashSet<>();

        for(int i = 0 ; i < n1; i ++){
            for (int j = 0; j < n2; j++) {
                int[] tempArr = new int[2];
                tempArr[0] = nums1[i];
                tempArr[1] = nums2[j];
                if(!set.contains(tempArr)){
                    priorityQueue.offer(tempArr);
                    set.add(tempArr);
                }

            }
        }
    }
    public static int findKthLargest() {
        int[] nums = {3,2,1,5,6,4} ;
        int k = 6;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }
    public static void fastSort(int[] nums, int left, int right){
        if(left>right){
            return;
        }
        int mid = left;
        int start = left;
        int end = right;
        while(start<end){
            while(nums[mid]>=nums[end]&&start<end){
                end--;
            }
            while(nums[start]>=nums[mid]&&start<end){
                start++;
            }
            if(start<end){
                int temp1 = nums[start];
                nums[start] = nums[end];
                nums[end] = temp1;
            }
        }
        int temp2 = nums[start];
        nums[start] = nums[mid];
        nums[mid] = temp2;
        fastSort(nums, left, end-1);
        fastSort(nums,end+1,right);
    }
    public static int[] searchRange() {
        int[] nums = new int[]{1};
        int target = 1;
        int left = 0;
        int right = nums.length-1;
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int mid = 0;
        while(left <= right){
            mid = (left+right)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid;
                break;
            }
        }
        ;

        if(nums[mid]!=target){
            return new int[]{-1,-1};
        }
        while(left>=0&&nums[left]==target){
            left--;
        }
        while(mid<nums.length&&nums[mid]==target){
            mid++;
        }
        return new int[]{left+1,mid-1};


    }
}
