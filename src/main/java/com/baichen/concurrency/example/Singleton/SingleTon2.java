package com.baichen.concurrency.example.Singleton;

import com.baichen.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 饿汉模式
 * @author: baichen
 * @create: 2019-01-22 21:38
 **/
@ThreadSafe
public class SingleTon2 {
    public final static SingleTon2 INSTANCE = new SingleTon2();

    private SingleTon2() {
    }

    public static SingleTon2 getInstance() {
        return INSTANCE;
    }
}
