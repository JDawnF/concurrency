package com.baichen.concurrency.example.actomic;

import com.baichen.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: concurrency
 * @description: 并发测试
 * @author: baichen
 * @create: 2019-01-20 22:03
 **/

@Slf4j
@ThreadSafe
public class AtomicIntegerFieldUpdaterExample {
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterExample> updater=AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterExample.class,"count");
    @Getter
    public volatile int count=100;
    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterExample example=new AtomicIntegerFieldUpdaterExample();
        if (updater.compareAndSet(example,100,120)){
            log.info("update success 1,{}",example.getCount());
        }
        if(updater.compareAndSet(example,100,120)){
            log.info("update success 2,{}",example.getCount());
        }else{
            log.info("update failed,{}",example.getCount());
        }
    }
}
