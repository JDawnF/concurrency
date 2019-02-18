package com.baichen.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: concurrency
 * @author: baichen
 **/
@Slf4j
public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
//        executorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                log.warn("schedule run");
//            }
//        }, 1, 3, TimeUnit.SECONDS);//延迟一秒后每隔3秒执行

//        executorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                log.warn("schedule run");
//            }
//        }, 4, TimeUnit.SECONDS);//延迟3秒执行

//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    log.info("task:{}", index);
//                }
//            });
//        }
//        executorService.shutdown();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 5 * 1000);   //间隔5s再执行
    }
}
