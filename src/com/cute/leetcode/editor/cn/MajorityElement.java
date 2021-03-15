//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 798 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();

        int[] nums = {3,3,4};
        int i = solution.majorityElement(nums);
        System.out.println(i);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
       /* Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num: nums) {
            map.put(num, map.get(num) != null ? map.get(num) + 1 : 1);
        }

        int max = 0;
        int maxValue = 0;

        for (int key : map.keySet()) {
            if (map.get(key) > maxValue) {
                max = key;
                maxValue = map.get(key);
            }
        }

        return max;*/

        /*Arrays.sort(nums);
        return nums[nums.length / 2];*/

        // 投票法
        int count = 0;
        Integer candidate = null;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }

        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}