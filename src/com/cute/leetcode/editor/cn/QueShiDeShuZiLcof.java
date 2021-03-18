//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
//这个数字。 
//
// 
//
// 示例 1: 
//
// 输入: [0,1,3]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [0,1,2,3,4,5,6,7,9]
//输出: 8 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 10000 
// Related Topics 数组 二分查找 
// 👍 117 👎 0

package com.cute.leetcode.editor.cn;
public class QueShiDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new QueShiDeShuZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        // 线性查找 O(N)
        /*int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i;*/

        // 有序数组，二分查找
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == mid)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}