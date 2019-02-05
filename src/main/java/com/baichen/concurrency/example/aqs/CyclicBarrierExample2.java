package com.baichen.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program: concurrency
 * @author: baichen
 **/
@Slf4j
public class CyclicBarrierExample2 {
    //使用方法3：在初始化的时候设置runnable，当线程达到屏障时优先执行runnable
    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        log.info("callback is running");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race2(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        executorService.shutdown();
    }
    //使用方法1：每个线程都持续等待
    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await();    //达到设置的线程数之后，才会执行await后面的代码
        log.info("{} continue", threadNum);
    }
    //使用方法2：每个线程只等待一段时间
    private static void race2(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await();
        log.info("{} continue", threadNum);
    }
}
