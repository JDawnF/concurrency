package com.baichen.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program: concurrency
 * @author: baichen
 **/
@Slf4j
public class SemaphoreExample1 {
    private static int threadCount = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3); //3个线程
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
//            Thread.sleep(1);  //不应该放在这里
            exec.execute(() -> {
                try {
                    semaphore.acquire(3); // 获取n个许可，表示只有几个线程可以执行
                    test(threadNum);//需要并发控制的内容
                    semaphore.release(3); // 释放n个许可
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        log.info("{}", threadNum);
        Thread.sleep(100);
    }
}
