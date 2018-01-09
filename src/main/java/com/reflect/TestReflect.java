package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws Exception{
        //返回A的构造方法
        Constructor c = A.class.getConstructor();
        //返回A类的所有为public 声明的构造方法
        Constructor[] cons = A.class.getConstructors();
        //返回A类所有的构造方法，包括private
        Constructor[] cons2 = A.class.getDeclaredConstructors();
        //返回A类的第一个public 方法
        Method m = A.class.getMethod("say");
        //执行
        m.invoke(A.class.newInstance(), null);
        //反射私有方法
        Method mm=A.class.getDeclaredMethod("say",String.class);
        mm.setAccessible(true);
        mm.invoke(A.class.newInstance(),"hello");
        //返回A类所有的public 方法
        Method[] ms = A.class.getMethods();
        //返回A类所有的方法，包括private
        Method[] allMs = A.class.getDeclaredMethods();
        //返回A类的public字段
        Field field = A.class.getField("i");
        System.out.println(field.get(A.class.newInstance()));
        //返回A类的static 字段
        Field field2 = A.class.getField("b");
       System.out.println(field2.get(null));
       //使用反射调用静态方法
        Method mmm = A.class.getMethod("hello");
        mmm.invoke(null);
        //利用反射来调用私有的构造函数生成对象
        Constructor con=A.class.getDeclaredConstructor(String.class);
        con.setAccessible(true);
        Object a=con.newInstance("iiiii");

    }
}
//类只有public，abstract,final和默认修饰符
class A{
    public int i = 1;
    public static int b = 2;
    public A(){
        System.out.println("无参构造");
    }
    private A(String s){
        System.out.println("有参构造"+s);
    }
    public static void hello (){
        System.out.println("i love you");
    }
    public void say(){
        System.out.println("say");
    }
    private void say(String s){
        System.out.println(s);
    }
}
