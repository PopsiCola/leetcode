package com.cute.interview.thread;

import java.util.concurrent.*;

/**
 * 线程池的案例
 * @Author liulebin
 * @Date 2021/6/3 13:42
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }

    /**
     * 线程池
     */
    private static void threadPoolInit() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5); // 一池5个处理线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor(); // 一池1个处理线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool(); // 一池N个处理线程

        try {
            for (int i = 1; i <= 10; i++) {
                threadPool3.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool3.shutdown();
        }
    }
}
