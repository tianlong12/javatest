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
    public Father() {
        // TODO Auto-generated constructor stub
        say();
    }

    public void say() {
        System.out.println("I'm father");
    }
    public static void main(String[] args) {

    }
}
