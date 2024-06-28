package com.cai.demo2;

import java.util.ArrayList;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        getCode();
        User u = new User();
        u.userMain();
        StudentSystem ss = new StudentSystem();
        ss.startStudentSystem();





    }






    public static String getCode(){
        Random r = new Random();
        int random_num = r.nextInt(48,58);
        int random_index = r.nextInt(0,4);
        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            characterArrayList.add((char)(i+'a'));
            characterArrayList.add((char)(i+'A'));
        }
        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int random_character = r.nextInt(0,53);

            characters.add(characterArrayList.get(random_character));
        }
        characters.add(random_index,(char)random_num);
        System.out.println(characters);
        return characters.toString();


    }
}
