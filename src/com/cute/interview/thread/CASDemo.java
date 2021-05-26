package com.cute.interview.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS（比较并交换 CompareAndSwap）
 * @Author liulebin
 * @Date 2021/5/26 22:35
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        // true	 current data: 2021
        // false	 current data: 2021
        System.out.println(atomicInteger.compareAndSet(5, 2021) + "\t current data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t current data: " + atomicInteger.get());
    }
}
