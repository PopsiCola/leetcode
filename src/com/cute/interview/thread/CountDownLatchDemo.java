package com.cute.interview.thread;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @Author liulebin
 * @Date 2021/6/1 20:36
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国被灭");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "秦国统一天下");
    }
}
