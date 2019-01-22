package com.baichen.concurrency.example.Singleton;

import com.baichen.concurrency.annotations.NotThreadSafe;

/**
 * @program: concurrency
 * @description: 懒汉式，线程不安全
 * @author: baichen
 * @create: 2019-01-22 21:34
 **/
@NotThreadSafe
public class SingleTon1 {
    //单例对象
    public static SingleTon1 INSTANCE = new SingleTon1();

    //私有构造函数
    private SingleTon1() {
    }
    //静态的工厂方法
    public static SingleTon1 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingleTon1();
        }
        return INSTANCE;
    }
}
