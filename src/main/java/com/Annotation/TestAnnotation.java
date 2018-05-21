package com.Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited
//该注解可以作用于方法,类与接口
@Target({ElementType.METHOD,ElementType.TYPE})
//JVM会读取注解,所以利用反射可以获得注解
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    //定义成员变量
    //成员变量可以通过default指定默认值
    //如果成员变量不指定默认值的情况下
    //我们在引用接口时则必须给没有默认值的成员变量赋值
    String name() ;
    int age() default 18 ;
}
