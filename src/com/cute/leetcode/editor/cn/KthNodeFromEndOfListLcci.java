//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 63 👎 0

package com.cute.leetcode.editor.cn;

import java.util.*;

public class KthNodeFromEndOfListLcci {
    public static void main(String[] args) {
        Solution solution = new KthNodeFromEndOfListLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        // list方法
        /*List<Integer> list = new ArrayList<>();
        list.add(head.val);

        while (head.next != null) {
            head = head.next;
            list.add(head.val);
        }
        return list.get(list.size() - k);*/

        // 双指针
        /*ListNode target = head, slow = target, fast = target;
        // 先走k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 当指针不为空时，同时走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;*/


        // 栈
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }

        // 弹出k个
        for (int i = 0; i < k - 1; i++) {
            deque.pop();
        }
        return deque.pop();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}