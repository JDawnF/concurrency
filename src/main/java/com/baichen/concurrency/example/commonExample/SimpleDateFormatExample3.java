package com.baichen.concurrency.example.commonExample;

import com.baichen.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: concurrency
 * SimpleDateFormat非线程安全,放入方法中变成局部变量就线程安全，要每次都得创建一个对象
 * @author: baichen
 **/
@Slf4j
@ThreadSafe
public class SimpleDateFormatExample3 {
    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();    //判断当前线程是否允许被执行
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }

    private static void update(int i) {
        //日期转换
        log.info("{}, {}", i, DateTime.parse("20190127", dateTimeFormatter).toDate());
//        DateTime.parse("20190127", dateTimeFormatter).toDate();
    }
}
