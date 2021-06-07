package com.cute.interview.oom;

/**
 * @Author liulebin
 * @Date 2021/6/7 21:51
 */
public class StackOverflowDemo {

    public static void main(String[] args) {
        testStackOverFlow();
    }

    private static void testStackOverFlow() {
        testStackOverFlow();
    }
}
