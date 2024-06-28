package com.cai.demo10;

public class L3 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int fast=1;
        int slow=0;
        while(fast<nums.length){
            if(nums[slow]==nums[fast]){
                fast++;
            }else{
                slow++;
                nums[slow]=nums[fast];
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
        return slow+1;
    }
}
