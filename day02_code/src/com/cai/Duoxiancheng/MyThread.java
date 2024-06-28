package com.cai.Duoxiancheng;

import java.util.Random;

public class MyThread extends Thread{
    static private  double Money=100;
    static private int count=3;

    @Override
    public void run() {
        synchronized (MyThread.class){
            if(count==0){
                System.out.println(getName()+"meiqiangdao");
            }
            else {
                if(count==1){
                    System.out.println(getName()+"最后得到了"+Money);
                    count--;
                }else {
                    Random r =  new Random();
                    double m = r.nextDouble(Money);
                    Money-=m;
                    System.out.println("红包还剩"+Money);
                    System.out.println("------");
                    System.out.println(getName()+"得到了"+m);
                    count--;
                    System.out.println(count);
                }
            }

        }

    }
}
