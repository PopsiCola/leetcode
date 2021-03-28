//稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。 
//
// 示例1: 
//
//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ta"
// 输出：-1
// 说明: 不存在返回-1。
// 
//
// 示例2: 
//
//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], 
//s = "ball"
// 输出：4
// 
//
// 提示: 
//
// 
// words的长度在[1, 1000000]之间 
// 
// Related Topics 二分查找 
// 👍 45 👎 0

package com.cute.leetcode.editor.cn;
public class SparseArraySearchLcci {
    public static void main(String[] args) {
        Solution solution = new SparseArraySearchLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findString(String[] words, String s) {
        /*for (int i = 0; i < words.length; i++) {
            if (s.equals(words[i])) {
                return i;
            }
        }
        return -1;*/

        // 二分查找
        int left = 0, right = words.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(words[mid].equals("") && !words[left].equals(s)){
                left++;
                continue;
            }else if(words[left].equals(s)){
                return left;
            }

            if(words[mid].equals(s)){
                return mid;
                //mid在s后面
            }else if(words[mid].compareTo(s) > 0){
                right = mid;
                //mid在s前面
            }else if(words[mid].compareTo(s) < 0){
                left = mid + 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}