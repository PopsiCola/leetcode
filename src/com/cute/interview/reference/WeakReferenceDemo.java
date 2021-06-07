package com.cute.interview.reference;

import java.lang.ref.WeakReference;

/**
 * @Author liulebin
 * @Date 2021/6/6 21:08
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> reference = new WeakReference<>(o1);


        System.out.println(o1);
        System.out.println(reference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(reference.get());
    }
}
