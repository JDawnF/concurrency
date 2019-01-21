package com.baichen.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: concurrency
 * @description: synchronized 修饰一个静态方法,同一时间只有一个线程可以执行
 * @author: baichen
 * @create: 2019-01-21 21:52
 **/
@Slf4j
public class SynchronizedExample3 {
    public static synchronized void test(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test - {} - {}",j,i);
        }
    }
    //使用线程池方法进行测试：
    public static void main(String[] args) {
        SynchronizedExample3 example1 = new SynchronizedExample3();
        SynchronizedExample3 example2 = new SynchronizedExample3();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //1,2两个线程测试
        executorService.execute(()-> example1.test(1));
        executorService.execute(()-> example2.test(2));
    }
}
