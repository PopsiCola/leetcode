package com.cute.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 十大排序算法
 * @Author liulebin
 * @Date 2021/3/17 9:31
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2, 34, 6, 191, 131, 34, 2, 3, 5, 15, 26, 27, 36};
        long start = System.currentTimeMillis();
        // int[] nums = bubbleSort(arr);
        // int[] nums = selectionSort(arr);
        // int[] nums = insertSort(arr);
        // int[] nums = shellSort(arr);
        // int[] nums = mergeSort(arr);
        int[] nums = quickSort(arr, 0, arr.length -1);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时(ms)：" + (end -start));
    }

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    private static int[] selectionSort(int[] arr) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j -1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }

    /**
     * 希尔排序
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        int length = arr.length;
        int tmp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                tmp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = tmp;
            }
        }
        return arr;
    }

    /**
     * 归并排序
     * @param arr
     * @return
     */
    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    protected static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    /**
     * 快速排序
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition -1);
            quickSort(arr, partition + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    /**
     * 数组两数值位置交换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
