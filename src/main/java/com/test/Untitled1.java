package com.test;

class base1{
    private int i;
    public void seti(){
        set();
    }
    public int get(){
        return i;
    }
    private void set(){//把子类父类此方法改为public，在看结果！！！！！！！！！！！！！！！！！！！！！！！！！
        i=5;
    }
}
public class Untitled1 extends base1{
    private int i;
    private void set(){
        i=4;
    }
    public static void main(String[] args) {
        Untitled1 u=new Untitled1();
        base1 b=new base1();
        base1 b3=new Untitled1();
        b3.seti();
        b.seti();
        u.seti();
        // seti();
        System.out.println(b3.get());
        System.out.println("u.i="+u.i+"\nb.i=" +b.get());
    }
}