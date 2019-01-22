package com.baichen.concurrency.example.Singleton;

import com.baichen.concurrency.annotations.NotRecommand;
import com.baichen.concurrency.annotations.NotThreadSafe;
import com.baichen.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 双重同步锁单例模式
 * @author: baichen
 * @create: 2019-01-22 21:34
 **/
@NotThreadSafe
public class SingleTon4 {
    //单例对象
    public static SingleTon4 INSTANCE = new SingleTon4();

    //私有构造函数
    private SingleTon4() {
    }
    //静态的工厂方法
    public static synchronized SingleTon4 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingleTon4.class){    //同步锁,可能会发生指令重排，发生错误
                if (INSTANCE == null){
                    INSTANCE = new SingleTon4();
                }
            }
        }
        return INSTANCE;
    }
}
