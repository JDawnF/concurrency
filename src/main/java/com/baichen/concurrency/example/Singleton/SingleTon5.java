package com.baichen.concurrency.example.Singleton;

import com.baichen.concurrency.annotations.NotThreadSafe;
import com.baichen.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 双重同步锁单例模式
 * @author: baichen
 * @create: 2019-01-22 21:34
 **/
@ThreadSafe
public class SingleTon5 {
    //单例对象,volatile防止指令重排
    public static volatile SingleTon5 INSTANCE = new SingleTon5();

    //私有构造函数
    private SingleTon5() {
    }
    //静态的工厂方法
    public static synchronized SingleTon5 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingleTon5.class){    //同步锁
                if (INSTANCE == null){
                    INSTANCE = new SingleTon5();
                }
            }
        }
        return INSTANCE;
    }
}
