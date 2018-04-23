package com.test;
import java.util.Scanner;
import java.util.TreeMap;


public class Test {
    public final void yy(){}
    public static int  gcd(int a,int b){
        if(a<b){
            int tmp=a;
            a=b;
            b=tmp;
        }

        if(b==0){
            return a;
        }
        int h=a%b;
        return gcd(b,h);

    }
    public static void main(String[] args) {
        System.out.println(gcd(18,6));
    }
}
