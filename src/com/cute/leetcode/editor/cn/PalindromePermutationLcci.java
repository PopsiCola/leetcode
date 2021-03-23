//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串 
// 👍 44 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PalindromePermutationLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromePermutationLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        // 方法一：hashmap
        // 出现次数
        if(s.length()==0) return true;
        int showCount = 0;
        Map<Character, Integer> resMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            resMap.put(s.charAt(i), resMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : resMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                showCount++;
                if (showCount > 1)
                    return false;
            }
        }
        return true;
        // 方法二：stack
        /*char[] chars = s.toCharArray();
        // 对String转换后的数组进行排序，使相同的字符在一起好操作
        Arrays.sort(chars);
        Stack<Character> stack = new Stack<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            // 利用stack，一个个放入堆栈，如果发现当前栈顶的元素与要放的一样，则出栈，相当于两个消失（对对碰）
            if (!stack.isEmpty() && stack.peek() == chars[i]) {
                stack.pop();
                continue;
            } else {
                // 直接放入
                stack.push(chars[i]);
            }
        }
        // 全部执行完后，如果是回文串的话，堆栈里只可能有一个元素，或者没有元素。
        return stack.isEmpty() || stack.size() == 1;*/

        /*if(s.length()==0) return true;
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        int jug=0;
        for(int i=0;i<chars.length-1;i++){  //为什么length-1？防止[i+1]溢出
            if(chars[i]!=chars[i+1]){
                i--;
                jug++;
            }
            i++;
            if(jug>0&&i==chars.length-2||jug>1) return false;
        }
        return true;*/


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}