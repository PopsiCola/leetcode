//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 128 👎 0

package com.cute.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        /*Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.get(num) != null ? count.get(num)+1 : 1);
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : count.entrySet()) {
            if (integerIntegerEntry.getValue() > nums.length / 2) {
                return integerIntegerEntry.getKey();
            }
        }
        return 0;*/

        // 投票法
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}