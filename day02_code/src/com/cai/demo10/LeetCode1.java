package com.cai.demo10;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0} ;
        int[] nums2 = {2,5,6};
        test1(nums1,3,nums2,3);
    }

    public static  void test1(int[] nums1, int m, int[] nums2, int n){
        ArrayList<Integer> arrayList = new ArrayList<>(m+n);
        for (int i = 0; i < m; i++) {
            arrayList.add(nums1[i]);
        }
        int index = m;
        for (int i = 0; i < n; i++) {
            arrayList.add(index,nums2[i]);
            index++;
        }
        Collections.sort(arrayList);
        for (int i = 0; i < m+n; i++) {
            nums1[i] = arrayList.get(i);
        }

    }
}
