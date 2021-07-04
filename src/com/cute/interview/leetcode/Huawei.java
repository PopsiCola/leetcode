package com.cute.interview.leetcode;

import java.util.Scanner;

/**
 * @Author liulebin
 * @Date 2021/6/24 13:51
 */
public class Huawei {

    public static void main(String[] args) {
       /* CQueue queue = new CQueue();
        queue.appendTail(3);
        int head = queue.deleteHead();
        int head = queue.deleteHead();*/
    }

    private static void zzsxl() {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int n = in.nextInt();
        // sum(x x+1 x+2 ... x+n-1) = sum
        // n*x + n*(n-1)/2 = sum
        // x= [sum - n*(n-1)/2 ]/n
        int temp = sum - n * (n - 1) / 2;
        if (temp <= 0 || temp % n != 0) {
            System.out.println(-1);
            return;
        }
        int begin = temp / n;
        for (int i = 0; i < n; i++) {
            System.out.print(begin + i);
            System.out.print(' ');
        }
    }
}
