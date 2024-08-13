package com.cai.demo10;

import java.util.ArrayList;
import java.util.List;

public class L14 {
    public static void main(String[] args) {

    }
    static List<String> list = new ArrayList<>();
    static String[] strArr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations() {
        String digits =  "234";
        StringBuilder sb = new StringBuilder();
        digui(digits, sb, 0);
        return list;
    }

    public static void digui(String digits, StringBuilder sb, int index){
        if(index== digits.length()){
            list.add(sb.toString());
            return ;
        }
        int c = Integer.parseInt(digits.charAt(index)+"")  ;
        for(int i=0; i < strArr[c].length(); i++){
            sb.append(strArr[c].charAt(i));
            digui(digits,sb,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    static List<List<Integer>> listCombine = new ArrayList<>();

    public static List<List<Integer>> combine() {
        int n = 4;
        int k = 2;
       List<Integer> list1 = new ArrayList<>();
        digui2(n, list1, 0,k);
        return listCombine;
    }

    public static void digui2(int n, List<Integer> list1, int index, int k){ //n 为分枝数 k为深度
        if(list1.size()==k){                          //递归几次,即几重循环  //这里不能用index来判断，因为递归传入的index为i+1，所以只能通过list的size来判断是否递归了两次
            listCombine.add(new ArrayList<>(list1));
            return;
        }
        for(int i=index; i <n; i++){
            list1.add(i+1);        //值差1
            digui2(n,list1,i+1,k);

            list1.removeLast();
        }
    }

    static List<List<Integer>> list2 = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        digui(nums,list,used);

        return list2;
    }
    public static void digui(int[] nums, List<Integer> list, boolean[] used) {
        if(list.size()==nums.length){
            list2.add(new ArrayList<>(list));
            return ;
        }
        for(int i = 0 ; i < nums.length; i++ ){
            if(used[i]){
                continue;
            }else{
                used[i] =true;
                list.add(nums[i]);
                digui(nums,list,used);
                list.removeLast();  //回溯
                used[i] = false;  //回溯
            }
        }
    }
    public boolean exist(char[][] board, String word) {
        List<String> list = new ArrayList<>();
        boolean[][] boardFalse = new boolean[board.length][board[0].length];
        back(0,0,board,word,0,list, boardFalse);
        return list.size()==word.length();
    }

    public void back(int i, int j, char[][] board, String word, int index, List<String> list, boolean[][] boardFalse){


    }
}
