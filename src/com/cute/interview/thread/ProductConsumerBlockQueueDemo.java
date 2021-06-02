package com.cute.interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 堵塞队列来实现生产者和消费者模式
 * @Author liulebin
 * @Date 2021/6/2 20:57
 */
class MyResource {
    private volatile Boolean FLAG = true;   // 默认开启，进行到生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProduct() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (FLAG) {

            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);

            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停，表示FLAG=false，生产工作结束");
    }

    public void myConsumer() throws InterruptedException {

        String result = null;
        while (FLAG) {

            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")) {
                System.out.println(Thread.currentThread().getName() + "\t 超过两秒没有取到消息，消费退出");
                return;
            }

            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
        }
    }

    public void stop() {
        this.FLAG = false;
    }
}

public class ProductConsumerBlockQueueDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动成功");
            try {
                myResource.myProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Prod").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动成功");
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println("5秒时间到，大老板main线程叫停，活动结束");
        myResource.stop();
    }
}
