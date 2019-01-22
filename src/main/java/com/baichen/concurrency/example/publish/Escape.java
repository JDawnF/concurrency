package com.baichen.concurrency.example.publish;

import com.baichen.concurrency.annotations.NotRecommand;
import com.baichen.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: concurrency
 * @description: 对象逸出
 * @author: baichen
 * @create: 2019-01-22 21:23
 **/
@Slf4j
@NotThreadSafe
@NotRecommand
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape () {
        new InnerClass();
//        thisCanBeEscape = null;
    }

    //内部类构造方法调用外部类的私有域
    private class InnerClass {

        public InnerClass() {
            //this逸出
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
