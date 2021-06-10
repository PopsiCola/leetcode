package com.cute.interview.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * hashmap源码解析
 * @Author liulebin
 * @Date 2021/6/7 10:18
 */
public class HashMapDemo {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(map.get(target - nums[i]) != null) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 9;

        twoSum(nums, target);

        /*ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("小明", "xiaoming");
        System.out.println(map.get("小明"));*/

        int num = 58;
        System.out.println(num << 1);
    }


    private static final int tableSizeFor(int c) {
        int n = c - 1;
        System.out.println(n);
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
