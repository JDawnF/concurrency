package com.baichen.concurrency.example.threadLocal;

/**
 * @program: concurrency
 * @description: ThreadLocal对象的类
 * @author: baichen
 **/
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    //后面会存入线程的id，请求的时候添加，通过filter进行过滤实现
    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }
    //处理后拦截器处理
    public static void remove() {
        requestHolder.remove();
    }
}
