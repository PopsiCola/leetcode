package com.cute.interview.thread;

/**
 * 可重入锁 synchronized
 * @Author liulebin
 * @Date 2021/6/10 21:48
 */
public class ReEnterLockDemo2 {

    static Object objectLockA = new Object();

    public static void m1() {
        new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println(Thread.currentThread().getName() + "\t外层调用");
                synchronized (objectLockA) {
                    System.out.println(Thread.currentThread().getName() + "\t中层调用");
                    synchronized (objectLockA) {
                        System.out.println(Thread.currentThread().getName() + "\t内层调用");
                    }
                }
            }
        }, "t1").start();
    }

    public static void main(String[] args) {
        m1();
    }
}
