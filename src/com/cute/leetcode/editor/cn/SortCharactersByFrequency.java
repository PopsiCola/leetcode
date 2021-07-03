//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 
// 👍 280 👎 0

package com.cute.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution solution = new SortCharactersByFrequency().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character> list = new ArrayList<>(charCount.keySet());
        Collections.sort(list, (a, b) -> charCount.get(b) - charCount.get(a));

        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Character c = list.get(i);
            for (int j = 0; j < charCount.get(c); j++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}