package com.cute.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁（递归锁）
 * 指的是同一线程外层函数获得锁后，内层递归函数仍然能获取改锁的代码，
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。
 * 即 线程可以进入任何一个它已经拥有的锁所同步着的代码块。可重入锁最大的作用就是避免死锁。
 *
 * synchronized和ReentrantLock就是一个典型的可重入锁
 * @Author liulebin
 * @Date 2021/5/30 22:37
 */

class Phone implements Runnable{
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "发送短信：sendSMS");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "发送邮件：synchronized");
    }

    @Override
    public void run() {
        getSMS();
    }

    // ===================ReentrantLock====================
    Lock lock = new ReentrantLock();
    public void getSMS() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取短信消息：getSMS");
            getEmail();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void getEmail() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取邮件消息：getEmail");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ReenterLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Thread t3 = new Thread(phone, "t1");
        Thread t4 = new Thread(phone, "t1");

        t3.start();
        t4.start();
    }

}
