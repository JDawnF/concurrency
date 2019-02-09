package com.baichen.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: concurrency
 * @author: baichen
 * AQS和condition的等待队列
 **/
@Slf4j
public class ConditionExample {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();//创建condition
        //线程1
        new Thread(() -> {
            try {
                reentrantLock.lock();   //加入AQS等待队列
                log.info("wait signal"); // 1，输出等待信号
                condition.await();      //从AQS队列中移除，即锁的释放,然后加入condition的队列
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("get signal"); // 4
            reentrantLock.unlock();
        }).start();
        //线程2
        new Thread(() -> {
            reentrantLock.lock();   //因为线程1释放锁后获取锁，加入AQS等待队列
            log.info("get lock"); // 2
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();//发送信号,线程1中condition的节点加入AQS，还未被唤醒
            log.info("send signal"); // 3
            reentrantLock.unlock(); //释放锁，AQS中线程1被唤醒
        }).start();
    }
}
