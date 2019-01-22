package com.baichen.concurrency.example.immutable;

import com.baichen.concurrency.annotations.NotThreadSafe;
import com.baichen.concurrency.annotations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @program: concurrency
 * @description: 不可变对象
 * @author: baichen
 * @create: 2019-01-22 23:02
 **/
@Slf4j
@ThreadSafe
public class ImmutableExample2 {
    private  static Map<Integer,Integer> map=Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        //会报错， java.lang.UnsupportedOperationException
        map=Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
//        这个都会报错，因为用final修饰的不能改变
//        a=2;
//        b="3";
//        map=Maps.newHashMap();
        //可以修改值
        map.put(1,3);
        log.info("{}",map.get(1));
    }
}
