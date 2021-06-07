package com.cute.interview.oom;

import java.util.Random;

/**
 * 堆内存溢出
 * @Author liulebin
 * @Date 2021/6/7 21:41
 */
public class JavaHeapSpaceDemo {

    public static void main(String[] args) {
        String str = "stringstr";

        while (true) {
            str += str + new Random().nextInt(111111) + new Random().nextInt(2222222);
            str.intern();
        }
    }
}
