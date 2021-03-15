//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1578 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        int[] nums = {5,2, 2, 4, 5};
        int i = solution.singleNumber(nums);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {

        // 使用异或
        // var a = [2,3,2,4,4]
        //
        // 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
        /*int single = 0;
        for(int num : nums) {
            single = single ^ num;
        }
        return single;*/

        // 使用Map
        Map map = new HashMap();
        for(int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, num);
            }
        }
        int value = 0;
        for(Object key : map.keySet()) {
            value = (int) key;
        }
        return value;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}