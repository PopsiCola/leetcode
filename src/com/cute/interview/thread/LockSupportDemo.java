package com.cute.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockSupport有什么作用
 * @Author liulebin
 * @Date 2021/6/10 22:32
 */
public class LockSupportDemo {

    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // 被堵塞，等待通知放行，他要通过则需要许可证
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t被唤醒");
        }, "A");
        a.start();

        TimeUnit.SECONDS.sleep(2);

        Thread b = new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t通知");
        }, "B");
        b.start();
    }

    private static void lockAwaitSignal() throws InterruptedException {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\tcome in");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "\t被唤醒");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t通知");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

    /**
     * synchronized
     * @throws InterruptedException
     */
    private static void synchronizedWait() throws InterruptedException {
        new Thread(() -> {
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\tcome in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t被唤醒");
            }
        }, "A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t通知");
            }
        }, "B").start();
    }
}
