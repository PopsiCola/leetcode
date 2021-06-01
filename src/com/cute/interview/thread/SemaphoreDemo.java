package com.cute.interview.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author liulebin
 * @Date 2021/6/1 21:15
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "停车3秒后离开车位");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, String.valueOf(i)).start();
        }
    }
}
