package com.cai.demo10;

import java.util.*;

public class L18 {
    public static void main(String[] args) {
        twoSum();

    }
    public static int[][] findMinArrowShots() {
        int[][] points = {{1,3},{2,6},{8,10},{11,18}};
        Arrays.sort(points, (o1, o2) -> o1[0]-o2[0]);
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while(i<points.length-1){
            int start = points[i][0];
            int end = points[i][1];
            int j = i+1;
           while(i<points.length-1&&j<points.length){
                int next_start = points[j][0];
                if(end>=next_start){
                    end = points[j][1];
                    j++;
                }else{
                    break;
                }
            }
            list.add(new int[]{start,end});
            i = j;
            if(i==points.length-1){
                list.add(new int[]{points[i][0],points[i][1]});
            }
        }

        return list.toArray(int[][]::new);
    }
    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int i = 0;
        int count = 0;
        while(i<points.length){
            int start = points[i][0];
            int end = points[i][1];
            int j = i+1;
            while(i<points.length&&j<points.length){
                int next_start = points[j][0];
                if(end>next_start){
                    end = Math.min(points[j][1],end);
                    j++;
                }else{
                    break;
                }
            }
            i = j;
            count++;

        }
        return count;
    }
    public  static int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        while(i<intervals.length&&intervals[i][0]<newInterval[0]){
            i++;
        }
        int[][] arr = new int[intervals.length+1][2];
        int index = 0;
        for(int j = 0 ; j < intervals.length+1 ; j++){
            if(j==i){
                arr[j] = newInterval;
            }else{
                arr[j] = intervals[index];
                index++;
            }

        }
        return rongHe(arr);
    }

    public static int[][] rongHe(int[][] arr) {
        int i = 0;
        List<int[]> list = new ArrayList<>();
        while (i < arr.length) {
            int j = i + 1;
            int start = arr[i][0];
            int end = arr[i][1];
            while (i < arr.length && j < arr.length && end <= arr[j][0]) {
                end = Math.max(end, arr[j][1]);
                j++;
            }
            list.add(new int[]{start, end});
        }

        return list.toArray(int[][]::new);
    }
    public static int longestConsecutive() {
        int [] nums = {100,4,200,1,3,2};
        Arrays.sort(nums);
        int n = nums.length;
        int slow = 0;
        int max = 0;
        while(slow<n){
            int fast = slow+1;
            int count = 0;
            while(slow<n&&fast<n&&(nums[fast]-1==nums[fast-1]||nums[fast]==nums[fast-1])){
                if(nums[fast]-1==nums[fast-1]){
                    count++;
                }
                fast++;


            }
            max = Math.max(count,max);
            slow = fast;
        }
        String str = "sd";

        return max;
    }
    public static List<List<String>> groupAnagrams() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i = 0 ; i < n; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String temp_string = Arrays.toString(charArray);
            if(map.containsKey(temp_string)){
                map.get(temp_string).add(strs[i]);
            }else{
                map.put(temp_string,new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        String str = new String();

        return new ArrayList<List<String>>(map.values());
    }
    public static void gameOfLife() {
        int[][] board =
                {{0,1,0},
        {0,0,1},
            {1,1,1},
        {0,0,0}};
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        int[][] new_board = new int[m][n];
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                count = newLife(board, i , j, m , n);

                if(count==3||(count==2&&board[i][j]==1)){
                    new_board[i][j] = 1;
                }else{
                    new_board[i][j] = 0;
                }
            }
        }
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = new_board[i][j];
            }
        }

    }
    public static int newLife(int[][] board, int i, int j, int m, int n){
        int count = 0;
        for(int heng = i-1; heng< m&& heng <= i+1; heng++){
            if(heng<0){
                continue;
            }
            for(int shu = j-1; shu < n && shu <=j+1; shu++){
                if(heng==i&&shu==j||shu<0){
                    continue;
                }
                if(board[heng][shu]==1){
                    count++;
                }
            }
        }

        return count;
    }
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] =matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

    public static List<Integer> spiralOrder() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;
        int i = 0;
        int j = 0;
        while(left<=right&&top<=bottom){
            i = top;
            j = left;
            while(left<=right&&top<=bottom&&j<=right){
                list.add(matrix[i][j]);
                j++;
            }
            top++;
            j = right;
            i = top;
            while(left<=right&&top<=bottom&&i<=bottom){
                list.add(matrix[i][j]);
                i++;
            }
            right--;

            i = bottom;
            j = right;
            while(left<=right&&top<=bottom&&j>=left){
                list.add(matrix[i][j]);
                j--;
            }
            bottom--;

            j = left;
            i = bottom;
            while(left<=right&&top<=bottom&&i>=top){
                list.add(matrix[i][j]);
                i--;
            }
            left++;

        }
        return list;
    }

    public static boolean isValidSudoku() {
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                if(set.contains(board[i][j])){
                    return false;
                }else{
                    set.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            Set<Character> set2 = new HashSet<>();
            for (int j = 0; j < m; j++) {
                if(board[j][i]=='.'){
                    continue;
                }
                if(set2.contains(board[j][i])){
                    return false;
                }else{
                    set2.add(board[j][i]);
                }
            }
        }
        for (int i = 1; i < m; i+=3) {

            for (int j = 1; j < n; j+=3) {
                Set<Character> set = new HashSet<>();
                for(int heng =i-1;heng<=i+1;heng++){
                    for (int shu = j-1; shu <= j+1; shu++) {
                        if(board[heng][shu]=='.'){
                            continue;
                        }
                        if(set.contains(board[heng][shu])){
                            return false;
                        }
                        set.add(board[heng][shu]);

                    }

                }

            }
        }
        return true;
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return  s.length();
        }

        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 1;
        int n = s.length();
        int count = 1;
        int max = 0;
        set.add(s.charAt(slow));
        while(fast<n){
            while(fast<n&&!set.contains(s.charAt(fast))){
                set.add(s.charAt(fast));
                fast++;
                count++;
            };

            max = Math.max(count,max);
            while(fast<n&&set.contains(s.charAt(fast))){
                set.remove(s.charAt(slow));
                slow++;
                count--;
            }
        }
        return max;
    }
    public static List<List<Integer>> threeSum() {
        int[] nums = {-1,0,1,2,-1,-4};
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        int index1 = 0;
        while(index1<n-2){
            if(nums[index1]>0){
                break;
            }
            int index2 = index1+1;
            int index3 = n-1;
            while(index1<n-2&&index3<n&&index2<index3){
                int sum = sum(nums, index1, index2, index3);
                if(sum>0){
                    index3--;
                }else if(sum<0){
                    index2++;
                }else{
                    List<Integer> list2 = new ArrayList<>();
                    Collections.addAll(list2,nums[index1],nums[index2],nums[index3]);
                    set.add(list2);
                    index3--;
                    index2++;
                }
            }
            index1++;
        }
        return set.stream().toList();
    }
    public static int sum(int[] nums, int index1, int index2, int index3){
        return nums[index1]+nums[index2]+nums[index3];
    }
    public static int[] twoSum() {
        int[] numbers = {2,3,4};
        int target = 6;
        int n = numbers.length;
        int left = 0 ;
        int right = n-1;
//        while(left <= right){
//            int mid = (left+right)/2;
//            if(numbers[mid]<target){
//                left = mid+1;
//            }else if(numbers[mid]>target){
//                right = mid -1;
//            }else{
//                left = mid;
//                break;
//            }
//        }
//        right = left-1;
//        left = 0;
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum>target){
                right--;
            }else if(sum<target){
                left++;
            }else{
                return new int[]{left+1,right+1};
            }
        }
        return new int[]{left+1,right+1};
    }
}
