package com.baichen.concurrency.example.immutable;

import com.baichen.concurrency.annotations.NotThreadSafe;
import com.baichen.concurrency.annotations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @program: concurrency
 * @description: 不可变对象
 * @author: baichen
 * @create: 2019-01-22 23:02
 **/
@Slf4j
@ThreadSafe     //因为是不可变的，所以一定是线程安全的
public class ImmutableExample3 {
    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);
    private final static ImmutableSet set = ImmutableSet.copyOf(list);
    //参数里面是一对对k-v
    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);
    //通过put方法放进去然后调用build方法
    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
        //list.add(4);    //被淘汰，会报错
       // set.add(4);       //被淘汰，会报错
        //map.put(1,4);     //被淘汰，会报错
       // map2.put(1,4);      //被淘汰，会报错
        System.out.println(map2.get(3));
    }
}
