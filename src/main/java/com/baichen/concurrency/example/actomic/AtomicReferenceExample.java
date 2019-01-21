package com.baichen.concurrency.example.actomic;

import com.baichen.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: concurrency
 * @description: 并发测试
 * @author: baichen
 * @create: 2019-01-20 22:03
 **/

@Slf4j
@ThreadSafe
public class AtomicReferenceExample {
    private static AtomicReference<Integer> count=new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);   //2
        count.compareAndSet(0,1);   //不执行
        count.compareAndSet(1,3);   //不执行
        count.compareAndSet(2,4);   //4
        count.compareAndSet(3,5);   //不执行
        log.info("count:{}",count.get());
    }
}
