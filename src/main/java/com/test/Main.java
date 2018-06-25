package com.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {


    public static void main(String[] args) {
        ArrayList a=new ArrayList();
        a.add(1);
        a.add(2);
        a.removeAll(a);

        System.out.println(a.size());
    }
}
