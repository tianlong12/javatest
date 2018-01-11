package com.design_pattern.Singleton;

public class Singleton2 {
    //饿汉，先生成实例
    private static Singleton2 instance = new Singleton2();
    private Singleton2 (){}
    public static Singleton2 getInstance() {
        return instance;
    }
}
