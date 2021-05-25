package com.cute.interview.thread;

import java.util.concurrent.TimeUnit;

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
public class VolatileDemo {

    public static void main(String[] args) {
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
