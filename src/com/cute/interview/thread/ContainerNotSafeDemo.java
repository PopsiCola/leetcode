package com.cute.interview.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类线程不安全的问题
 * ArrayList
 * Set
 * @Author liulebin
 * @Date 2021/5/30 19:09
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        // 线程不安全，也会有这个异常：java.util.ConcurrentModificationException
        // Map<String, Object> map = new HashMap<>();
        // Map<String, Object> map = Collections.synchronizedMap(new HashMap<>());
        Map<String, Object> map = new Hashtable<>();

        for (int i = 1; i < 30; i++) {
            new Thread(() -> {
                map.put(UUID.randomUUID().toString().substring(0, 8), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 线程安全的set
     */
    private static void setNotSafe() {
        // 也会有这个异常：java.util.ConcurrentModificationException
        // Set<String> set = new HashSet<>();
        // 线程的set
        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    /**
     * 1.故障现象
     *  不安全的list，在多线程下，会出现java.util.ConcurrentModificationException异常
     * 2.导致原因
     *  并发修改导致，一个人正在写入，另一个人过来抢夺，导致数据不一致异常。并发修改异常
     * 3.解决方案
     *  3.1 Vector
     *  3.2 Collections.synchronizedList(new ArrayList<>());
     *  3.3 new CopyOnWriteArrayList<>();
     */
    private static void listNotSafe() {
        // 不安全的list，在多线程下，会出现java.util.ConcurrentModificationException异常
        // List<String> list = new ArrayList<>();
        // 解决list不安全问题
        // List<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
