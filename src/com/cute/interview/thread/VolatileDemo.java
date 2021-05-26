package com.cute.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile的可见性demo
 * @Author liulebin
 * @Date 2021/5/25 22:42
 */
class MyData {
    volatile int number = 0;
    // int number = 0;
    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        this.number++;
    }

    // 实现原子性
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }

}


public class VolatileDemo {

    public static void main(String[] args) {
        /**
         * volatile不保证原子性Demo
         * 如何解决原子性：
         *  1.加synchronize
         *  2.使用我们的juc下的AtomicInteger
         */
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t number value is " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t atomicInteger value is " + myData.atomicInteger);

    }

    /**
     * 验证volatile的可见性
     *  假如int number = 0； number变量之前根本没有添加volatile关键字修饰
     *  控制台输出： AAA	 come in
     *              AAA	 updated number value:60
     *
     *  volatile修饰后，控制台输出：
     *              AAA	 come in
     *              AAA	 updated number value:60
     *              main	 mission is over, value is 60
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // 暂停一会
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value:" + myData.number);
        }, "AAA").start();

        // 第二个线程main线程
        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over, value is " + myData.number);
    }
}
