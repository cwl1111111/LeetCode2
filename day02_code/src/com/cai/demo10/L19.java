package com.cai.demo10;

import java.util.ArrayList;
import java.util.List;

public class L19 {
    public static void main(String[] args) {
        lengthOfLIS();
    }
    public static boolean isPalindrome() {
        String s = "A man, a plan, a canal: Panama";
        String s1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int length = s1.length();
        for (int i = 0, j = length-1; i < length ; i++,j--) {
            if(s1.charAt(i)!=s1.charAt(j)){
                return false;
            }

        }
        return true;
    }
    public static boolean isPalindrome2() {
        String s = "A man, a plan, a canal: Panama";
        char[] charArr = s.toCharArray();
        int len = charArr.length;
        int left = 0;
        int right = len-1;
        while(left<right){
            while(left<right&&!Character.isLetterOrDigit(charArr[left])){
                left++;
            }
            while(left<right&&!Character.isLetterOrDigit(charArr[right])){
                right--;
            }
            if( Character.toLowerCase(charArr[left]) !=Character.toLowerCase(charArr[right])){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
    public static String convert() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        int index = 0;
        int len = s.length();
        int row = 0;
        int reverte = -1;
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        while(index<len){
            list.get(row).append(s.charAt(index));
            if(row==numRows-1||row==0){
                reverte=reverte*-1;
            }
            row+=reverte;
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder sbb : list) {

                sb.append(sbb);

        }
        return sb.toString();
    }
    public static String reverseWords(String s) {
        String[] split = s.strip().split(" +");
        int n = split.length;
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >=0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public static int trap() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxLeft = 0;
        int maxRight = 0;
        for(int i = 0, j = n-1 ; i < n; i++,j--){
            maxLeft = Math.max(height[i],maxLeft);
            maxRight =  Math.max(height[j],maxRight);
            left[i] = maxLeft-height[i];
            right[j] = maxRight-height[j];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=Math.min(left[i],right[i]);
        }
        return 0;
    }
    public static int[] productExceptSelf() {
        int[] nums = {1,2,3,4};
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int sumL = 1;
        int sumR = 1;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            sumL *= nums[i];
            left[i] = sumL;
            sumR *= nums[j];
            right[j] = sumR;
        }
        int[] res = new int[n];
        res[0] = right[1];
        res[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }
    public static int removeDuplicates() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int slow = 2;
        int fast = slow;
        int n = nums.length;
        if(n<=2){
            return n;
        }
        while(fast<n){
            if(nums[fast]!=nums[slow-2]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;

        }

        return slow;
    }
    public static int removeElement() {
        int[] nums = {3,3};
        int val = 5;
        int n = nums.length;
        int i = n-1;
        int index = i;
        int res= i;
        while(i>=0&&index>=0){
            while(i>=0&&nums[i]==val){
                i--;
                res = i;
            }
            index = i;
            while(index>=0&&nums[index]!=val){
                index--;
            }
            if(i>=0&&index>=0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        return res+1;
    }
    public static int minDistance() {
        String word1 = "intention";
        String word2 = "execution";
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0 ; i <= m ; i++){
            dp[i][0] = i;
        }
        for(int i = 0 ; i <= n ; i++){
            dp[0][i] = i;
        }
        for(int i = 1 ; i <= m; i++){
            for( int j = 1; j <= n ; j++){
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    dp[i][j] =Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) +1;
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
    public static boolean isInterleave() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i <= m ; i++){
            if(s1.charAt(i-1)==s3.charAt(i-1)&&dp[i-1][0]){
                dp[i][0] = true;
            }

        }
        for(int i = 1; i <= n ; i++){
            if(s2.charAt(i-1)==s3.charAt(i-1)&&dp[0][i-1]){
                dp[0][i] = true;
            }
        }

        for(int i = 1 ; i <= m ; i++){
            for( int j = 1 ; j<= n ; j++){
                if(s1.charAt(i-1)==s3.charAt(i+j-1)&&dp[i-1][j]){
                    dp[i][j] = true;
                }
                if(s2.charAt(j-1)==s3.charAt(i+j-1)&&dp[i][j-1]){
                    dp[i][j] = true;
                }

            }
        }
        return dp[m][n];
    }
    public static String longestPalindrome() {
        String s = "cbbd";
        int len = s.length();
        int max = 0;
        int start = 0;
        int end = 0;
        for(int i = 0 ; i < len; i++){
            for(int j = 0; j < 2 ; j++){
                int count = 0;
                int left = i;
                int right = i+j;
                while(left>=0&&right<len) {
                    if (s.charAt(left) == s.charAt(right)) {
                        count++;
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
                int countTemp = 0;

                if(j==0){
                    countTemp = count*2-1;
                }else{
                    countTemp = count*2;
                }
                if(countTemp>max){
                    max = countTemp;
                    if(j==0){
                        start = i-count+1;
                        end = i+count;
                    }else{
                        start = i-count+1;
                        end = i+1+count;
                    }
                }
            }

        }
        return s.substring(start,end);
    }
    public static int lengthOfLIS() {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for(int i = 1 ; i < n; i++ ){
            for(int j = 0 ; j < i; j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
}
