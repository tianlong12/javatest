package com.junit;

import com.test.Father;

public class Son extends Father {
    //int f=new Father().i;此时是访问不到的，虽然i是protected,但是只能通过子类去访问，例如利用super关键字。
    int t=8;
    private int a=7;
    public Son() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void say() {
        // TODO Auto-generated method stub
        System.out.println("I'm son "+i);
    }
    @Override
    public int getA() {
        return a;
    }

    public static void main(String[] args) {


       int b= new Son().i;
      // int c=new Father().i;不可以这样




    }
}
