package com.cute.interview.thread;

/**
 * 单例模式多线程下保持单例
 * @Author liulebin
 * @Date 2021/5/26 21:33
 */
public class SingletonDemo {

    private static volatile SingletonDemo singletonDemo = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 执行了");
    }

    // DCL(Double Check Lock 双端检索机制)
    public static SingletonDemo getInstance() {
        if (singletonDemo == null) {
            synchronized (SingletonDemo.class) {
                if (singletonDemo == null) {
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }

    public static void main(String[] args) {
        // 单线程下单例模式没有问题
        /*System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());*/

        // 多线程下单例模式，无法保持单例
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }

    }


}
