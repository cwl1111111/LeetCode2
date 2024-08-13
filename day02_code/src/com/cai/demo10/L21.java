package com.cai.demo10;

import java.util.ArrayList;
import java.util.List;

public class L21 {
    public static void main(String[] args) {
        exist();
    }
    public static int maxSubarraySumCircular() {
        int[] nums = {1,-2,3,-2};

        int n = nums.length;
        int left = 1;
        int right = n-1;
        int[] dp1 = new int[n];
        dp1[left] = nums[left];

        int min =  dp1[left];
        for(int i = left+1; i < right; i++){
            dp1[i] = Math.min(nums[i], nums[i]+dp1[i-1]);
            min = Math.min(min,dp1[i]);
        }
        int[] dp2 = new int[n];

        dp2[0] = nums[0];
        int max = dp2[0];
        for(int i = 1; i < n; i++){
            dp2[i] = Math.max(nums[i], nums[i]+dp2[i-1]);
            max = Math.max(max,dp2[i]);
        }

        return Math.max(max+min,max);
    }
    public static boolean exist() {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        int m = board.length;
        int n = board[0].length;
        for(int i = 0 ; i < m ; i++){
            for( int j = 0 ; j < n ; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean[][] dp = new boolean[m][n];

                    if(isword(board, i , j, word, dp, 0)){
                        return true;
                    }
                }
            }
        }
        return false;

    }
    public static boolean isword(char[][] board, int x, int y, String word,  boolean[][] dp, int index ) {
        if(x<0||x>=board.length||y<0||y>=board[0].length||dp[x][y]||board[x][y]!=word.charAt(index))  {
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        dp[x][y] = true;
        boolean res =
        isword(board,x+1,y,word,dp,index+1)||
        isword(board,x-1,y,word,dp,index+1)||
        isword(board,x,y+1,word,dp,index+1)||
        isword(board,x,y-1,word,dp,index+1);
        return res;

    }
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        back(sb,n, list,0,0);
        return list;
    }
    public void back(StringBuilder sb, int n, List<String> list, int left, int right){
        if(sb.length()==n*2){
            list.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append("(");
            back(sb,n,list,left+1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(left>right){
            sb.append(")");
            back(sb,n,list,left,right++);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }
}
