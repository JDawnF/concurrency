package com.baichen.concurrency.example.lock;

import com.baichen.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: concurrency
 * @description: 并发测试
 * @author: baichen
 * @create: 2019-01-20 22:03
 **/

@Slf4j
@ThreadSafe
public class ReentrantReadWriteLockExample {
    private final Map<String,Data> map=new TreeMap<>();
    private final ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    //加读锁
    public Data get(String key){
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }
    public Set<String> getAllKeys(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }
    //加写锁,要保证此时读锁都释放了，所以要放在读锁后面
    public Data put(String key,Data value){
        writeLock.lock();
        try {
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }
    class Data{

    }

}
