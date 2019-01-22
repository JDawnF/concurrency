package com.baichen.concurrency.example.Singleton;

import com.baichen.concurrency.annotations.NotRecommand;
import com.baichen.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 懒汉式，线程不安全
 * @author: baichen
 * @create: 2019-01-22 21:34
 **/
@ThreadSafe
@NotRecommand
public class SingleTon3 {
    //单例对象
    public static SingleTon3 INSTANCE = new SingleTon3();

    //私有构造函数
    private SingleTon3() {
    }
    //静态的工厂方法
    public static synchronized SingleTon3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingleTon3();
        }
        return INSTANCE;
    }
}
