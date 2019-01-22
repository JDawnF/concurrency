package com.baichen.concurrency.example.Singleton;

import com.baichen.concurrency.annotations.NotRecommand;
import com.baichen.concurrency.annotations.Recommand;
import com.baichen.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 枚举模式，最安全
 * @author: baichen
 * @create: 2019-01-22 22:03
 **/
@ThreadSafe
@Recommand
public class SingleTon7 {
    private SingleTon7() {
    }

    public static SingleTon7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private SingleTon7 singleton;
        //JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingleTon7();
        }

        public SingleTon7 getInstance() {
            return singleton;
        }
    }
}
