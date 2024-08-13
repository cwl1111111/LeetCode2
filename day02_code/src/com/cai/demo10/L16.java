package com.cai.demo10;

import java.util.*;

public class L16 {
    public static void main(String[] args) {


    }
    public static int lengthOfLIS() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for(int i = 1 ; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            max = Math.max(dp[i],max);

        }

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);


        return max;
    }
    public static int minimumTotal() {
        List<List<Integer>> triangle = new ArrayList<>();
        Collections.addAll(triangle, new ArrayList<>(Arrays.asList(2)), new ArrayList<>(Arrays.asList(3,4)), new ArrayList<>(Arrays.asList(6,5,7)),new ArrayList<>(Arrays.asList(4,1,8,3)));
        int len = triangle.size();
        int num = triangle.get(len-1).size();
        int[][] dp = new int[len][num];
        dp[0][0] = triangle.get(0).get(0);
        int round = 1;
        for(int i = 1; i<len;i++){
            round++;
            for(int j = 0; j < round ; j++){
                if(j==0){
                    dp[i][j] = triangle.get(i).get(j)+ dp[i - 1][j];
                }else if(j==round-1){
                    dp[i][j] = triangle.get(i).get(j)+dp[i - 1][j-1];
                }else{
                    dp[i][j] =triangle.get(i).get(j)+ Math.min(dp[i - 1][j-1],dp[i - 1][j]);
                }
            }
        }
        int min =Integer.MAX_VALUE;
        for(int j = 0 ; j < num;j++){
            min = Math.min(dp[len-1][j],min);
        }
        return min;

    }
    public static int minPathSum() {
        int[][] grid= {{1,2},{1,1}};
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] +=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0){
                    continue;
                }
                else if(i==0){
                    dp[i][j] = dp[i][j-1];
                }
                else if(j==0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static int countSubstrings() {
        String s = "aaa";
        int len = s.length();
        int count = 0;
        for (int i = 2; i <= len; i++) {
            int start = 0;
            int end = i;
            while(end <=len){
                String str = s.substring(start, end);
                StringBuilder sb = new StringBuilder(str);
                if (sb.reverse().toString().equals(str)) {
                    count++;
                }
                start++;
                end++;

            }
        }
        return count+len;
    }
    public static String longestPalindrome(String s) {
        String str = "";
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int count1 = 0;
            int count2 = 0;

            for (int j = 0; j < 2; j++) {

                int tempCount = 0;
                int left = i;
                int right = i + j;
                while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    tempCount++;
                    left--;
                    right++;
                }
                if (j == 0) {
                    count1 = tempCount * 2 - 1;
                } else {
                    count2 = tempCount * 2;
                }

            }
            int tempMax = Math.max(count1, count2);
            if (max < tempMax) {
                max = tempMax;
                if (tempMax % 2 == 0) {
                    str = s.substring(i + 1 - tempMax / 2, i + tempMax / 2);
                } else {
                    str = s.substring(i - tempMax / 2, i + tempMax / 2);
                }
            }

        }
        return str;
    }
    public static boolean isInterleave() {
        String s1= "a";
        String s2 = "b";
        String s3 ="ab";
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1+len2!=len3){
            return false;
        }
        if(len1==0){
            return s2.equals(s3);
        }
        if(len2==0){
            return s1.equals(s3);
        }

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            if(dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1)){
                dp[i][0] = true;

            }
        }
        for (int  i = 1; i <= len2; i++) {
            if(dp[0][i-1]&&s2.charAt(i-1)==s3.charAt(i-1)){
                dp[0][i] = true;

            }
        }

        for(int i = 1; i <= len1 ; i++){
            for(int j = 1 ; j <= len2; j++){
                if(dp[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1)){
                    dp[i][j] = true;

                }
                if(dp[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1)){
                    dp[i][j] = true;

                }
            }
        }
        if(dp[len1][len2]){
            return true;
        }
        return false;
    }
    public static   int minDistance() {
        String word1 = "horse";
        String word2 = "ros";

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0 ; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int i = 0 ; i <= len2; i++){
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1; //找到加1减1或替换的最小值+1，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
                }
            }
        }

        return dp[len1][len2];
    }
}
