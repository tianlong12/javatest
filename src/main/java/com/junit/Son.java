package com.junit;

import com.test.Father;

public class Son extends Father {
    //int f=new Father().i;此时是访问不到的，虽然i是protected,但是只能通过子类去访问，例如利用super关键字。
    int t=8;
    private int a=7;

    @Override
    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        Father d=new Son();
        System.out.println(d.getA());
    }
}
