package com.cai.demo10;

import java.util.*;

public class L10 {
    public static void main(String[] args) {

        isHappy(19);
    }
    public static void gameOfLife() {
        int[][] board={{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int m = board[0].length;
        int n = board.length;
        int[][] newBoard = new int[n][m];
        for (int i = 0; i <n; i++)
            for (int j = 0; j < m; j++) {
                int count=0;
                    for (int k = -1; k < 2; k++) {            //无意义，单指遍历三次，和与当前细胞的相对位置
                        for (int l = -1; l <2 ; l++) {          //无意义，单指遍历三次，和与当前细胞的相对位置
                            if(i+k>=0&&i+k<n&&j+l>=0&&j+l<m){       //可以判断是否到边界，四周出界则不遍历。
                                int widen = i+k;
                                int length = j+l;
                                if(widen==i&&length==j){     //不遍历自己
                                    continue;
                                }
                                if(board[widen][length]==1){   //存活细胞数量
                                    count++;
                                }
                            }
                    }
                    if(board[i][j]==0){
                        if(count==3){
                            newBoard[i][j]=1;
                        }else{
                            newBoard[i][j]=-1 ;                 //为了与默认创建数组中的0区分开。
                        }
                    }else{
                        if(count==2||count==3){
                            newBoard[i][j]=1;
                        }else{
                            newBoard[i][j]=-1;
                        }
                    }
                }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(newBoard[i][j]==-1){
                    newBoard[i][j]=0;
                }
                board[i][j] = newBoard[i][j];
            }
        }


    }
    public static boolean canConstruct() {
        String ransomNote="a";
        String magazine="b";

        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if(!map1.containsKey(magazine.charAt(i))){
                map1.put(magazine.charAt(i),1);
            }else {
                map1.put(magazine.charAt(i),map1.get(magazine.charAt(i))+1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(map1.containsKey(ransomNote.charAt(i))){
                map1.put(ransomNote.charAt(i),map1.get(ransomNote.charAt(i))-1);
            }else {
                return false;
            }
            if(map1.get(ransomNote.charAt(i))<0){
                return false;
            }
        }
        return true;

    }
    public static boolean canConstruct2() {
        String ransomNote="aa";
        String magazine="aab";
        int[] hashArr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            hashArr[magazine.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {

            hashArr[ransomNote.charAt(i)-'a']-=1;
            if(hashArr[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }
        return true;
    }
    public static boolean isIsomorphic() {
        String s = "egg";
        String t= "add";
        int lengthS = s.length();
        int lengthT = t.length();
        if(lengthS!=lengthT){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < lengthS; i++) {
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){                 //当key不重复，但是value重复，false
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){              //当key重复，且value为新的，false。
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean wordPattern() {
        String pattern= "abba";
        String s = "dog  cat     cat dog";
        String[] split = s.split(" +");
        if(pattern.length()!=split.length){
            return false;
        }
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i)+"")){
                if(map.containsValue(split[i])){
                    return false;
                }
                map.put(pattern.charAt(i)+"",split[i]);
            }else {
                if(!map.get(pattern.charAt(i)+"").equals(split[i])){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isAnagram() {
        String s="anagram" ;
        String t="nagaram";
        if(s.length()!=t.length()){
            return false;
        }
        int[] sArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i)-'a']+=1;
            sArr[t.charAt(i)-'a']-=1;
        }
        for (int i : sArr) {
            if (i!=0) {
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> groupAnagrams() {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};     //只能用map 多字符的映射只能用map
        List<List<String>> returnList= new ArrayList<>();
        Map<String,List<String>> map =  new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String str1 =Arrays.toString(charArr);
            if(!map.containsKey(str1)){
                map.put(str1,new ArrayList<>(Arrays.asList(str)));       //若没有key，则添加值时要创建list，这里可以直接put一个new arraylist。用Arrays.asList的方法
            }else {                                                         //任何类型的数组都可以作为参数传递给 Arrays.asList() 方法，包括基本类型数组和引用类型数组。
                map.get(str1).add(str);                                     //例如，Arrays.asList("one", "two", "three") 将返回包含三个字符串的列表
            }
        }
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            returnList.add(stringListEntry.getValue());
        }
        return returnList;
    }

    public static int[] twoSum() {
        int[] nums={3,2,4};
        int target=6;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(target==nums[i]+nums[j]){
                    return new int[]{i,j};
                }
            }
        }
       return new int[]{0,0};
    }
    public static int[] twoSum2() {
        int[] nums={3,2,4};
        int target=6;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
    public static boolean isHappy(int n) {

//        Integer num2= n;
//        Set<Integer> set = new HashSet<>();
//        int sum =0;
//        while(true){
//            if(sum ==1){
//                System.out.println("111");
//                return true;
//            }else if(sum ==-1) {
//                System.out.println("2122");
//                return false;
//            }else {
//                sum = suan(num2,set);
//                num2=sum;
//            }
//        }
//    }
//    public static int suan(Integer n,Set<Integer> set){
//        int sum=0;
//        while(n%10!=0){
//            sum+=(n%10)*(n%10);
//            n= n/10;
//        }
//        if(sum==1){
//            return sum;
//        }else{
//            if(set.contains(sum)){
//                return -1;
//            }
//            set.add(sum);
//            return sum;
//        }
//
    return true;
    }


}
