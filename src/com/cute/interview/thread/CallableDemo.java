package com.cute.interview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author liulebin
 * @Date 2021/6/2 21:50
 */
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println(Thread.currentThread().getName() + "******************");
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Runable -> FutureRunnable -> FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());

        new Thread(futureTask, "AAA").start();
        new Thread(futureTask2, "BBB").start();

        System.out.println(Thread.currentThread().getName() + "****************");
        int result01 = 100;
        int result02 = futureTask.get();

        /*while(!futureTask.isDone()) {

        }*/

        System.out.println("*******result：" + (result01 + result02));
    }
}
