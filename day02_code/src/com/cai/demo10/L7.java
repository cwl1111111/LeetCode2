package com.cai.demo10;

public class L7 {
    public static void main(String[] args) {
        maxSlidingWindow();
    }
    public static int subarraySum() {
        int[] nums={1,-1,0};
        int k=0;
        int count=0;
        if(nums.length==1){
            if(nums[0]==k){
                return 1;
            }else{
                return 0;
            }
        }
        int[] numsSum = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            numsSum[i] = sum;
        }
        for (int i = 0; i < numsSum.length-1; i++) {                //前缀和遍历相减组成任意前缀和
            if(numsSum[i]==k)
            {
                count++;
            }
            for (int j = i+1; j < numsSum.length; j++) {
                if (numsSum[j]-numsSum[i]==k) {
                    count++;
                }

            }
        }
        if(numsSum[nums.length-1]==k){
            count++;
        }
        System.out.println(count);
        return count;

    }
    public static int[] maxSlidingWindow() {
        int[] nums={7,8,4};
        int k=2;
        if(k==1){
            return nums;
        }
        int[] maxArr = new int[nums.length-k+1];
        int slow=0;
        int fast=k;
        while(fast<=nums.length){
            int max = nums[slow];
            for (int i = slow; i < fast; i++) {
                if(max<nums[i]){
                    max = nums[i];
                }
            }
            maxArr[slow] = max;
            slow++;
            fast++;
        }

        for (int i : maxArr) {
            System.out.println(i);
        }
        return maxArr;
    }
}
