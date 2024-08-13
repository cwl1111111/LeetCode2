package com.cai.demo10;

import java.util.Arrays;

public class L17 {
    public static void main(String[] args) {
        minimalKSum();
    }
    public static void merge() {
        int[] nums1 = {1,2,3,0,0,0} ;
        int m = 3;
        int[] nums2={2,5,6} ;
        int n = 3;
        if(m==0){
            nums1 = Arrays.copyOf(nums2,n);
            return ;
        }
        if(n==0){
            return;
        }
        int[] arr = new int[m+n];
        int index1 = 0 ;
        int index2 = 0;
        int num1 = 0;
        int num2 = 0;
        for(int i = 0 ; i < m+n; i++){
            num1 = index1>=m ? Integer.MAX_VALUE:nums1[index1];
            num2 = index2>=n ? Integer.MAX_VALUE:nums2[index2];
            if(num1 < num2){
                arr[i] = nums1[index1++];
            }else{
                arr[i] = nums2[index2++];
            }

        }
        nums1 =  Arrays.copyOf(arr,m+n);
        for (int i = 0; i < arr.length; i++) {
            nums1[i] = arr[i];
        }
        return;
    }
    public  static int removeElement() {
        int[] nums = {3,3};
        int val = 3;
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left<=right){
            while(left<=right&&nums[right]==val){
                right--;
            }
            while(left<=right&&nums[left]!=val){
                left++;
            }
            if(left<=right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

        }
        return left;

    }
    public static int hIndex() {

        int[] citations = {3,0,6,1,5};
        int n = citations.length;
        Arrays.sort(citations);
        for (int i =n-1 ; i >=0 ; i--) {
            int h = i+1;
            if(citations[n-h]>=h){
                return i+1;
            }
        }

        return 1;
    }
    public static boolean isIsomorphic(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if(len1!=len2){
            return false;
        }
        char[] arr = new char[len1];
        for(int i = 0 ; i < len1; i++){
            int num = s.charAt(i)-'a';
            if(arr[num]=='\0'){
                arr[num] = t.charAt(i);
            }else{
                if(arr[num] != t.charAt(i)){
                    return false;
                }
            }

        }


        return true;
    }
    public static long minimalKSum() {
        int[] nums = {5,6};
        int k = 6;
        int len = nums.length;
        long sum = 0 ;
        int count = 0 ;
        Arrays.sort(nums);
        for(int i = 0 ; i < len; i++){
            long number = i+1;
            while(nums[i]!=number){
                sum+=number;
                number +=1;
                count++;
                if(count==k){
                    return sum;
                }
            }

        }

        return sum;
    }



}
