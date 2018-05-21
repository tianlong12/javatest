package com.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@TestAnnotation(name="I'm class annotation")
public class Test {

    @TestAnnotation(name="I'm method annotation")
    public static void showAnnotation(){

    }
    public static void main(String[] args) {
        //解析注解
        //获得我们需要解析注解的类
        Class<Test> clz = Test.class;

        //解析Class
        //由于我们的注解是可以给类使用的,所以首先判断类上面有没有我们的注解
        //判断类上面是否有注解
        boolean clzHasAnnotation = clz.isAnnotationPresent(TestAnnotation.class);
        if(clzHasAnnotation){
            //类存在我们定义的注解
            //获得注解
            TestAnnotation clzAnnotation = clz.getAnnotation(TestAnnotation.class);
            //输出注解在类上的属性
            System.out.println("name="+clzAnnotation.name()+"\tage="+clzAnnotation.age());
        }

        //解析Method
        //两种解析方法上的注解方式
        //获得类中所有方法
        Method[] methods = clz.getMethods();
        //第一种解析方法
        for(Method m : methods){
            //获得方法中是否含有我们的注解
            boolean methodHasAnnotation = m.isAnnotationPresent(TestAnnotation.class);
            if(methodHasAnnotation){
                //注解存在
                //获得注解
                TestAnnotation methodAnnotation = m.getAnnotation(TestAnnotation.class);

                System.out.println("name="+methodAnnotation.name()+"\tage="+methodAnnotation.age());
            }
        }
        //第二种解析方式
        for(Method m : methods){
            //获得方法上所有注解
            Annotation[] annotations = m.getAnnotations();
            //循环注解
            for(Annotation a : annotations){
                //如果是我们自定义的注解
                if(a instanceof TestAnnotation){
                    //输出属性,需要强制装换类型
                    System.out.println("name="+((TestAnnotation)a).name()+"\tage="+((TestAnnotation)a).age());
                }
            }
        }

    }
}
