//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 366 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersection = solution.intersection(nums1, nums2);
        for (int i : intersection) {
            System.out.println(i);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   /* public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }


        set1.retainAll(set2);
        // return set1.stream().mapToInt(i -> i).toArray();
        // 手写
        return getIntersection(set1, set2);
    }*/

    // 排序+双指针
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 == num2) {
                set.add(num1);
                index1++;
                index2++;
            } else if (num1 < num2){
                index1++;
            } else {
                index2++;
            }
        }
        return set.stream().mapToInt(i -> i).toArray();
    }

        public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
            if (set1.size() > set2.size()) {
                return getIntersection(set2, set1);
            }
            Set<Integer> intersectionSet = new HashSet<Integer>();
            for (int num : set1) {
                if (set2.contains(num)) {
                    intersectionSet.add(num);
                }
            }
            int[] intersection = new int[intersectionSet.size()];
            int index = 0;
            for (int num : intersectionSet) {
                intersection[index++] = num;
            }
            return intersection;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}