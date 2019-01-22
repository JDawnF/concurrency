package com.baichen.concurrency.example.Singleton;

import com.baichen.concurrency.annotations.NotRecommand;
import com.baichen.concurrency.annotations.ThreadSafe;

/**
 * @program: concurrency
 * @description: 懒汉式，不安全
 * @author: baichen
 * @create: 2019-01-22 21:34
 **/
@ThreadSafe
public class SingleTon6 {
    //静态域要在静态代码块前面，不然会返回null,因为静态代码块和静态域是根据其顺序先后执行的
    public static SingleTon6 instance = null;

    static {
        instance = new SingleTon6();
    }

    private SingleTon6() {
    }

    public static synchronized SingleTon6 getInstance() {
        return instance;
    }
}
