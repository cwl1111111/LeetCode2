package com.cai.demo1;

import java.util.Random;

public class Role {
    private String name;
    private int blood;

    public Role(){}

    public Role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void attack(Role role){
        Random random = new Random();
        int r = random.nextInt(10)+1;
        role.setBlood(role.getBlood()-r);
        int role_blood = role.getBlood() < 0 ? 0:role.getBlood();
        role.setBlood(role_blood);
        System.out.println(this.name+"造成了"+ r+"点伤害，"+ role.getName()+"还剩下"+role.getBlood()+"点血");
    }
}
