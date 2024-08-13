package com.cai.demo10;

import java.util.*;

public class L22 {
    public static void main(String[] args) {
        findOrder();
    }
    public static List<List<Integer>> combine() {
        int n= 4;
        int k = 2;

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        triback(n,0,k,list, list2,0);

        return list;
    }
    public static void triback(int n, int round, int k, List<List<Integer>> list, List<Integer> list2,int index){
        if(round == k){
            list.add(new ArrayList<>(list2));
            return;
        }
        for(int i = index ; i < n; i++){
            list2.add(i+1);
            triback(n, round+1,k,list,list2,i+1);
            list2.removeLast();
        }
    }
    public static List<String> letterCombinations() {
        String digits = "23";
        char[][] wordArr = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'},};
        int len = digits.length();
        List<String> list = new ArrayList<>();
        huiSu(wordArr,list, new StringBuilder(), len, digits, 0,0);
        return list;
    }
    public static void huiSu(char[][] wordArr, List<String> list, StringBuilder sb, int len, String str,int round, int indexStr){
        if(round == len){
            list.add(sb.toString());
            return;
        }
        char[] tempArr = wordArr[Integer.parseInt(str.charAt(indexStr)+"") ];
        for (int i = 0; i < tempArr.length; i++) {
            sb.append(tempArr[i]);
            huiSu(wordArr,list,sb,len,str,round+1,indexStr+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static int minMutation() {
        String startGene = "AACCGGTT";
        String endGene = "AACCGCTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Set<String> repeat = new HashSet<>();
        if(!set.contains(endGene)){
            return -1;
        }
        char[] arr = {'A','C','G','T'};
        int len = startGene.length();
        Queue<String> que = new LinkedList<>();
        que.offer(startGene);
        int step = 0;
        while(!que.isEmpty()){
            int size = que.size();
            step++;
            for(int i = 0 ; i < size; i++) {
                StringBuilder sb = new StringBuilder(que.poll());
                if (endGene.equals(sb.toString())) {
                    return step;
                }

                for (int index = 0; index < len; index++) {
                    StringBuilder tempSb = new StringBuilder(sb);
                    for (int j = 0; j < 4; j++) {
                        tempSb.setCharAt(index,arr[j]);
                        if (set.contains(tempSb.toString()) && !repeat.contains(tempSb.toString())) {
                            que.offer(tempSb.toString());
                            repeat.add(tempSb.toString());
                        }
                    }

                }
            }
        }
        return -1;
    }
    public static int[] findOrder() {
        int numCourses = 2;
        int[][] prerequisites = {{0,1},{1,0}};
        List<Integer> list = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] du = new int[numCourses];
        int m = prerequisites.length;
        for(int i = 0 ; i < m; i++){
            if(map.containsKey(prerequisites[i][1])){
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else{
                map.put(prerequisites[i][1], new ArrayList<>());
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            du[prerequisites[i][0]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ; i <numCourses ;i++){
            if(du[i]==0){
                que.offer(i);
            }
        }
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0 ; i < size ; i ++){
                int tempCourse = que.poll();
                list.add(tempCourse);
                List<Integer> mapValues = map.get(tempCourse);
                if(mapValues!=null){
                    for(int mapValue : mapValues){
                        if(--du[mapValue]==0){
                            que.offer(mapValue);
                        }
                    }
                }
            }
        }
        int[] listArr = new int[numCourses];

        if(list.size()!=numCourses){
            return new int[0];
        }

        return list.stream().mapToInt(x->x).toArray();
    }
}
