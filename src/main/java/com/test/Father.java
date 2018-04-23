package com.test;

import com.junit.Son;

public class Father {
    protected int i=3;
    private int a=5;
    public int t=3;
    private void yy(){}
    public void yyy(){}

    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        Father a=new Son();
        System.out.println(a.getA());
    }
}
