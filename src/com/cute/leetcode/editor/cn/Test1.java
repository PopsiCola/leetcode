package com.cute.leetcode.editor.cn;

import java.util.Date;

/**
 * @Author llb
 * Date on 2020/6/18
 */
public class Test1 {
    public int hammingWeight(int n) {
        // int count = 0;
        // while(n != 0) {
        //     count += n&1;
        //     n >>>= 1;
        // }
        // return count;

        int count = 0;
        String str = String.valueOf(n);
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '1')

                count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        int n = 01011;
//        int i = new Test1().hammingWeight(n);
//        System.out.println(i);
        long start = System.currentTimeMillis();

        // for循环遍历10000次，耗时
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }

        // while循环遍历100000次，耗时 耗时：214ms
//        int i = 100000;
//        while (i > 0) {
//            System.out.println(i);
//            i--;
//        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end -start) + "ms");



    }
}
