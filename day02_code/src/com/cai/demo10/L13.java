package com.cai.demo10;

import java.util.*;

public class L13 {

    public static void main(String[] args) {
        minMutation();

    }
    public static int numIslands() {
        int num = 0;
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
                };
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    ganran(grid,i,j);
                    num++;
                }
            }
        }
        return  num;
    }

    public static void ganran(char[][] grid, int i, int j){
        if(i<0||i>grid.length||j<0||j>grid[0].length||grid[i][j]!='1'){
            return ;
        }
        grid[i][j] = '2';
        ganran( grid,  i-1,  j);
        ganran( grid,  i+1,  j);
        ganran( grid,  i,  j-1);
        ganran( grid,  i,  j+1);

    }

    public static void solve() {
        char[][] board = {
        {'X','X','X','X'},
        {'X','0','0','X'},
        {'X','X','0','X'},
        {'X','0','X','X'}};
        for (int i = 0; i < board[0].length; i++) {
            if(board[0][i]=='0'){
                ganran2(board,0,i,'-');
            }
            if(board[board.length-1][i]=='0'){
                ganran2(board,board.length-1,i,'-');
            }
        }
        for (int i = 0; i < board.length; i++) {
            if(board[i][0]=='0'){
                ganran2(board,i,0,'-');
            }
            if(board[i][board[0].length-1]=='0'){
                ganran2(board,i,board[0].length-1,'-');
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='0') {
                    ganran2(board, i, j, 'X');
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='-')board[i][j]='0';
            }
        }

    }
    public static void ganran2(char[][] board, int i, int j, char ch){
        if(i<0||i>=board.length||j<0||j>= board[0].length|| board[i][j]!='0'){
            return;
        }
        board[i][j] = ch;
        ganran2(board,i-1,j, ch);
        ganran2(board,i+1,j, ch);
        ganran2(board,i,j+1, ch);
        ganran2(board,i,j-1, ch);
        Map<Integer, List<Integer>> map = new HashMap<>();

    }
    public static int ladderLength() {
        String beginWord = "hot";
        String endWord = "dot";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog"));
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)||set.size()==0){
            return 0;
        }

        int step = 0;
        Queue<String> que = new LinkedList<>();
        Set<String> setQue = new HashSet<>();
        que.offer(beginWord);
        setQue.add(beginWord);
        while(!que.isEmpty()){
            int size = que.size();
            step++;                 //当前层的单词都不能匹配endword，将当前层的单词换一个字母转化成下一层单词
            for(int i = 0 ; i < size ; i++){    //for循环完代表当前层无匹配，生成下一层单词加入到deque和setQue.
                String currString = que.poll();
                if(currString.equals(endWord)){
                    return step;
                }else{
                    //通过改变一个字母来转化成下一个单词
                    for(int j = 0; j < currString.length(); j++){
                        StringBuilder sb = new StringBuilder(currString);
                        for(char ch = 'a'; ch<='z'; ch++){
                            if(ch==sb.charAt(j)){
                                continue;
                            }
                            String string = sb.replace(j, j+1, String.valueOf(ch)).toString();
                            if(set.contains(string)&&!setQue.contains(string)){     //将下一层单词加入到que，并排除已遍历过的单词
                                que.offer(string);
                                setQue.add((string));
                            }
                        }

                    }

                }
                if(que.isEmpty()&&setQue.size()!=set.size()){    //如果que为空（表示当前层遍历完）且set容器长度不相等（表示获取不到后面的单词），则当前的单词无法通过改变一个字母来转化成下一个单词
                    return 0;
                }
            }
        }
        if(step==1){    //不会有1 的情况，为1即为0.
            return 0;
        }
        return step;

    }
    public static int minMutation() {
        String startGene = "AAAAAAAT";
        String endGene = "CCCCCCCC";
        String[] bank = {"AAAAAAAC","AAAAAAAA","CCCCCCCC"};
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if(!set.contains(endGene)||set.size()==0){
            return -1;
        }

        int step = 0;
        Queue<String> que = new LinkedList<>();
        Set<String> setQue = new HashSet<>();
        que.offer(startGene);
        setQue.add(startGene);
        while(!que.isEmpty()){
            int size = que.size();
            step++;
            for(int i = 0 ; i < size ; i++){
                String currString = que.poll();
                if(currString.equals(endGene)){
                    return step-1;
                }else{

                    for(int j = 0; j < currString.length(); j++){
                        StringBuilder sb = new StringBuilder(currString);
                        for(char ch = 'A'; ch<='Z'; ch++){
                            if(ch==sb.charAt(j)){
                                continue;
                            }
                            String string = sb.replace(j, j+1, String.valueOf(ch)).toString();
                            if(set.contains(string)&&!setQue.contains(string)){
                                que.offer(string);
                                setQue.add((string));
                            }
                        }

                    }

                }
                if(que.isEmpty()&&setQue.size()-1!=set.size()){
                    return -1;
                }
            }
        }
        return step-1;
    }

}
