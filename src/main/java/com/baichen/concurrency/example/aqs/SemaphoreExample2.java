package com.baichen.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: concurrency
 * @author: baichen
 **/
@Slf4j
public class SemaphoreExample2 {
    private static int threadCount = 200;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3); //3个线程
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
//            Thread.sleep(1);  //不应该放在这里
            exec.execute(() -> {
                try {
                    //尝试获取许可，但是上面设定了同一时间只有3个线程可以获得许可,所以只会输出3个
                    if (semaphore.tryAcquire()){
                        test(threadNum);//需要并发控制的内容
                        semaphore.release(); // 释放许可
                    }
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
