package com.baichen.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: concurrency
 * @description: synchronized 修饰一个类
 * @author: baichen
 * @create: 2019-01-21 21:52
 **/
@Slf4j
public class SynchronizedExample4 {
    public static void test(int j){
        synchronized (SynchronizedExample4.class){
            for (int i = 0; i < 10; i++) {
                log.info("test - {}-{}",j,i);
            }
        }
    }
    //使用线程池方法进行测试：
    public static void main(String[] args) {
        SynchronizedExample4 example1 = new SynchronizedExample4();
        SynchronizedExample4 example2 = new SynchronizedExample4();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //1,2两个线程测试
        executorService.execute(()-> example1.test(1));
        executorService.execute(()-> example2.test(2));
    }
}
