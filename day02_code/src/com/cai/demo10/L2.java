package com.cai.demo10;

import java.util.ArrayList;
import java.util.Iterator;

public class L2 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        removeElement(nums,2);
    }
    public static int removeElement(int[] nums, int val) {
        int count=0;
        boolean isCun = true;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums) {
            arrayList.add(num);
        }
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            if(iterator.next()==val){
                iterator.remove();
                count++;
            };
        }

        for (int i = 0; i < nums.length-count; i++) {
            nums[i] = arrayList.get(i);
        }
        for (int num : nums) {
            System.out.println(num);
        }
        return nums.length-count;

    }
}
