//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串 
// 👍 29 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutationLcci {
    public static void main(String[] args) {
        Solution solution = new CheckPermutationLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation(String s1, String s2) {
            if (s1 == null || s2 == null)
                return false;
            /*if (s1.length() != s2.length()) {
                return false;
            }
            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            char[] arr = s1.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                map1.put(arr[i], map1.getOrDefault(arr[i], 0) + 1);
            }
            char[] arr1 = s2.toCharArray();
            for (int i = 0; i < arr1.length; i++) {
                map2.put(arr1[i], map2.getOrDefault(arr1[i], 0) + 1);
            }
            for (int i = 0; i < arr.length; i++) {
                if (map1.get(arr[i]) != map2.get(arr[i])) {
                    return false;
                }
            }
            return true;*/

            char[] c1=s1.toCharArray();
            Arrays.sort(c1);
            char[] c2=s2.toCharArray();
            Arrays.sort(c2);
            return new String(c1).equals(new String(c2));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}