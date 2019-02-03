package com.baichen.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: concurrency
 * @author: baichen
 **/
@Slf4j
public class CountDownLatchExample2 {
    private static int threadCount=200;

    public static void main(String[] args) throws Exception {
        ExecutorService exec=Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch=new CountDownLatch(threadCount);
        for (int i=0;i<threadCount;i++){
            final int threadNum=i;
//            Thread.sleep(1);  //不应该放在这里
            exec.execute(()->{
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("exception",e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        //await需要等到countDown变为0才会执行下面的代码
        // 可以设置等待时间，超过这个时间就会执行，不会等到计数器变为0
//        但是之前给定的线程还是会执行完
        countDownLatch.await(10,TimeUnit.MILLISECONDS);
        log.info("finish");
        exec.shutdown();
    }
    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("{}", threadNum);
    }
}
