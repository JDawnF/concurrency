package com.baichen.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: concurrency
 * @description: synchronized 修饰一个方法
 * @author: baichen
 * @create: 2019-01-21 21:52
 **/
@Slf4j
public class SynchronizedExample2 {
    public synchronized void test(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test - {} - {}",j,i);
        }
    }
    //使用线程池方法进行测试：
    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //1,2两个线程测试
        executorService.execute(()-> example1.test(1));
        executorService.execute(()-> example2.test(2));
    }
}
