package com.baichen.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: concurrency
 * @description: 线程不安全类标识注解
 * @author: baichen
 * @create: 2019-01-20 21:08
 **/
@Target(ElementType.TYPE)       //注解作用的目标，这里是对一个类作为注解
@Retention(RetentionPolicy.SOURCE)        //注解存在的范围,编译的时候会被忽略
public @interface NotThreadSafe {
    String value() default "";
}
