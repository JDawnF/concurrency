package com.baichen.concurrency.example.publish;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @program: concurrency
 * @description: 线程不安全的发布
 * @author: baichen
 * @create: 2019-01-22 21:17
 **/
@Slf4j
public class UnsafePublish {
    private String[] states={"a","b","c"};
    //类的非私有方法，返回私有对象的引用
// states变量作用域是private而我们在getStates方法中却把它发布了，
// 这样就称为数组states逸出了它所在的作用域。
    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        //通过new一个类的实例发布这个类对象
        UnsafePublish unsafePublish=new UnsafePublish();
        log.info("{}",Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0]="d";
        log.info("{}",Arrays.toString(unsafePublish.getStates()));
    }
}
