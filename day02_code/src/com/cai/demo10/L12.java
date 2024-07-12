package com.cai.demo10;

import java.nio.file.Path;
import java.util.*;

public class L12 {
    public static void main(String[] args) {
        simplifyPath();
    }
    public static int[][] merge() {
        int[][] intervals = { {1, 3},{2, 6}, {8, 10}, {15, 18}};
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int i=0;
        while(i<intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i+1;                                         //定义一个变量；
            while(j<intervals.length&&intervals[j][0]<=end){
                end = Math.max(end, intervals[j][1]);
                j++;

            }
            i=j;
            list.add(new int[]{start,end});
        }

        return list.toArray(int[][]::new);
    }
    public static int[][] insert() {
        int[][] intervals={{1, 3}};
        int[] newInterval={2,5};

        if(intervals.length==0){
            return new int[][]{newInterval};
        }
        //有序数组插入1
//        int[][] new_intervals = new int[intervals.length+1][2];
//        int insertIndex=intervals.length;
//        for (int i = 0; i < intervals.length; i++) {
//            if(intervals[i][0]>=newInterval[0]){
//                insertIndex=i;
//                new_intervals[insertIndex] = newInterval;
//                break;
//            }
//        }
//        System.arraycopy(intervals,0,new_intervals,0,insertIndex);
//        if(insertIndex==intervals.length){
//            new_intervals[insertIndex]=newInterval;
//        }else{
//            System.arraycopy(intervals,insertIndex,new_intervals,insertIndex+1,new_intervals.length-1-insertIndex);
//        }

        //有序数组插入2
        int[][] new_intervals = new int[intervals.length+1][2];
        System.arraycopy(intervals,0,new_intervals,0,intervals.length);
        new_intervals[new_intervals.length-1] = newInterval;
        Arrays.sort(new_intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
//有序数组插入3
//        list.sort(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return 0;
//            }
//        });



        int n = new_intervals.length;
        List<int[]> list = new ArrayList<>();

        int i = 0 ;
        while(i<n){
            int start = new_intervals[i][0];
            int end = new_intervals[i][1];

            int j = i+1;
            while(j<n&&end>=new_intervals[j][0]){
                end = Math.max(end,new_intervals[j][1]);
                j++;
            }
            list.add(new int[]{start,end});
            i = j;
        }
        return list.toArray(int[][]::new);
    }

    public static int findMinArrowShots() {
        int[][] points={{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);               //比o1[0]-o2[0]更安全，不会溢出
            }
        });
        int i=0;
        int count=0;
        while(i<points.length){
            int end=points[i][1];
            int j=i+1;
            while(j<points.length&&end>=points[j][0]){
                end = Math.min(end,points[j][1]);
                j++;
            }
            i=j;
            count++;
        }
        return count;
    }
    public static boolean isValid() {
        String s="){";
        if(s.length()<=1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>(){};
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
            {
                list.add(s.charAt(i));
            }
            else{
                if(list.size()==0||s.charAt(i)!= map.get(list.get(list.size()-1))){
                    return false;
                }
                else{list.remove(list.size()-1);}
            }
        }
        if(list.size()!=0){
            return false;
        }
        return true;
    }
    public static boolean isValid2() {
        String s="{[]}";
        if(s.length()<=1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>(){};
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Deque<Character> characters = new ArrayDeque<>();
//        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                characters.addLast(s.charAt(i));
            }else {
                if(characters.size()==0||map.get(characters.getLast())!=s.charAt(i)){
                    return false;
                }
                characters.removeLast();
            }
        }
        if(characters.size()!=0){
            return false;
        }
        LinkedList<Integer> list = new LinkedList<>();

        return true;
    }
    public static String simplifyPath() {
        String path = "/.";
        return Path.of(path).normalize().toString();

        // 先用/分开成list，后用栈，进入和退出。
//        path = path.replaceAll("/+","/");
//        if(path.startsWith("/")){
//            path = path.substring(1);
//        }
//        Deque<String> deque = new ArrayDeque<>();
//        String[] split = path.split("/+");
//        deque.addLast("/");
//        for (String s : split) {
//            if(s.equals(".")){
//                continue;
//            }
//            else if(s.equals("..")){
//                if(deque.size()>=2){
//                    deque.removeLast();
//                    deque.removeLast();
//                }else{
//                    deque.addLast("/");
//                }
//
//            }else {
//                deque.addLast(s);
//                deque.addLast("/");
//            }
//
//        }
//        if(deque.size()>1){
//            deque.removeLast();
//        }
//        StringBuilder sb = new StringBuilder();
//        for (String s : deque) {
//            sb.append(s);
//        }
//        path = sb.toString().replaceAll("//","/");
//        return path;
    }

}
