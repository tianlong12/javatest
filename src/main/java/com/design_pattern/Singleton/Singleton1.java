package com.design_pattern.Singleton;

public class Singleton1 {
    //懒汉，线程安全，但是效率低
        private static Singleton1 instance;
        private Singleton1 (){}
        public static synchronized Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

