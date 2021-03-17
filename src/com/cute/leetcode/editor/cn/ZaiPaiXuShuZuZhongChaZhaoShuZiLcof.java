//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 107 👎 0

package com.cute.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // hashmap方法
       /* Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }
        return map.get(target) == null ? 0 : map.get(target);*/


        int start = 0;
        int end = nums.length -1;
        while (end >= start && (nums[start] != target || nums[end] != target)) {
            if (nums[start] != target){
                start++;
            }
            if (nums[end] != target){
                end--;
            }
        }
        return end - start + 1 < 0 ? 0 : end - start + 1;
        // 二分法
        // return helper(nums, target) - helper(nums, target - 1);

    }
        int helper(int[] nums, int tar) {
            int i = 0, j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if(nums[m] <= tar) i = m + 1;
                else j = m - 1;
            }
            return i;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}