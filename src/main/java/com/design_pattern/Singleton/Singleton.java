package com.design_pattern.Singleton;

public class Singleton {
    //懒汉，线程不安全。instance是类对象，构造方法是私有方法。
    private static Singleton instance;
    private Singleton (){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
