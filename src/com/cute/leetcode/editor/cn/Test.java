package com.cute.leetcode.editor.cn;
import java.time.*;
import java.util.*;

/**
 * @Author llb
 * Date on 2020/6/11
 */
public class Test extends Thread {

    boolean flag = true;

    public static void main(String[] args) {
        //        String s1 = "Programming";
        //        String s2 = new String("Programming");
        //        String s3 = "Program";
        //        String s4 = "ming";
        //        String s5 = "Program" + "ming";
        //        String s6 = s3 + s4;
        //        List<String> list = new ArrayList<>();
        //        Map<String, Object> map = new HashMap<>();
        //        Set<String> set = new HashSet<>();
        //        Set<String> strings = Collections.synchronizedSet(set);
        //        int i = 100;
        //        System.out.println(String.valueOf(i));
        //        System.out.println(s1 == s2);               //false
        //        System.out.println(s1 == s5);               //true
        //        System.out.println(s1 == s6);              //false
        //        System.out.println(s1 == s6.intern());   //true
        //        System.out.println(s2 == s2.intern());    //false

        /***************************使用两个队列模拟堆栈****************************/
        /*Queue<String> queue = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        List<String> list = new ArrayList<>();

        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        System.out.print("进栈：");
        for (String str : queue) {
            list.add(str);
            System.out.print(str + " ");
        }


        for (int i = list.size()-1; i >= 0 ; i--) {
            queue2.add(list.get(i));
        }

        System.out.println();
        System.out.print("出栈：");
        for (String str : queue2) {
            list.add(str);
            System.out.print(str + " ");
        }*/

//        Map<String, Object> map = new HashMap<>();
//        map.put(null, null);
//        System.out.println(map.get(null));
//
//        Test test = new Test();


        /************************线程**************************/
//        System.out.println("开启线程：");
//
//        new Thread() {
//            @Override
//            public void run() {
//                    try {
//                        System.out.println("线程执行睡眠");
//                        Thread.sleep(2000);
//                        System.out.println("线程睡眠结束");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//            }
//        }.start();
//
//
//        System.out.println("执行下面代码");


        Test test = new Test();
        new Thread(){
            @Override
            public void run() {
                for(int i=0; i<3; i++) {
                    test.subThread();
                }
            }
        }.start();

        for (int i = 0; i < 3; i++) {
            test.mainThread();
        }


    }

    public synchronized void mainThread() {
        if(flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "=========主线程执行" + (int)(i+1) + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;

        notify();
    }

    public synchronized void subThread() {
        if(!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "=========子线程执行" + (int)(i+1) + "次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        flag = false;

        notify();
    }
}
