package com.cai.demo5;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String str = "Java1awdasdadw java14 dwidiwioitJava21";

        String r = "Java\\d+"; //String r = "Java\\d{1,2}";
        Pattern p = Pattern.compile(r);
        Matcher m =  p.matcher(str);
        StringBuilder s = new StringBuilder();
        while(m.find()){
            s.append(m.group());
        }
        System.out.println(s.toString());

        String vs = str.replaceAll(r, "vs");
        System.out.println(vs);


        Date date = new Date();
        date.getTime();
        Integer i = Integer.parseInt("100");


    }
}
