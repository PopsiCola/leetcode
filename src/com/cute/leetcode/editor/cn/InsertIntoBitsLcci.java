//给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。 
//
// 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。 
//
// 
//
// 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。 
//
// 
//
// 示例1: 
//
// 
// 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
// 输出：N = 1100(10001001100)
// 
//
// 示例2: 
//
// 
// 输入： N = 0, M = 31(11111), i = 0, j = 4
// 输出：N = 31(11111)
// 
// Related Topics 位运算 
// 👍 26 👎 0

package com.cute.leetcode.editor.cn;
public class InsertIntoBitsLcci {
    public static void main(String[] args) {
        Solution solution = new InsertIntoBitsLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int insertBits(int N, int M, int i, int j) {
       /* 例 N = 1011 1111, M = 101, i = 2, j = 4
        (1<<(j-i+1))-1)<<i = 0001 1100
        取反后
        1110 0011                       //(1<<(j-i+1))-1)这样计算出的数取反后能把数 N 中 i 到 j 位置置为0
        对N于运算
        1011 1111 & 1110 0011 = 1010 0011       //把上一步的0替换到 N 中 i 到 j 位
        M左移动i位
        101 << i = 0001 0100                // M的数组移到i 到 j 位中
        最后M|N
        0001 0100 | 1010 0011 = 1011 0111 = 183    //两者结合即为答案
*/
        int mask = ((1 << (j - i + 1)) - 1) << i;
        mask = ~mask;
        N &= mask;
        M = M<<i;
        return M|N;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}