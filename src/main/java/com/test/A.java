package com.test;

public class A {
    int a=method();
    static int l=method2();
    public A(){
        System.out.println("0");
    }
    public int method(){
        System.out.println("1");
        return 1;
    }
    public static int method2(){
        System.out.println("2");
        return 2;
    }
}
class B extends A{
    public int m=method3();
    public static int n=method4();
    public int t=0;
    public B(){
        System.out.println("3");
    }
    public int method3(){
        System.out.println("4");
        return 4;
    }
    public static int method4(){
        System.out.println("5");
        return 5;
    }

    public static void main(String[] args) {
        System.out.println("6");
        A a=new B();
    }
}