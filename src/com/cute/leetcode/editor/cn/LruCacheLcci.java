//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 98 👎 0

package com.cute.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCacheLcci {
    public static void main(String[] args) {
        // Solution solution = new LruCacheLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        // 方法一：LinkedHashMap
        /*int capacity;
        Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                // 获取key的值，删除key该值，再重新放入，达成最新使用在最后
                Integer value = map.remove(key);
                map.put(key, value);
                return value        ;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
                return;
            }
            map.put(key, value);
            // 判断map大小是否已满，如果已满删除最久未使用的
            if (map.size() > capacity) {
                map.remove(map.entrySet().iterator().next().getKey());
            }
        }*/

        // 方法二：map和双向链表
        private int capacity;
        private Map<Integer, ListNode> map;
        private ListNode head;  // dummy head
        private ListNode tail;  // dummy tail

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            // 是否map中存在key，存在需要删除再新增，实现最新使用
            if (map.containsKey(key)) {
                ListNode node = map.get(key);
                // 删除
                node.pre.next = node.next;
                node.next.pre = node.pre;

                moveToTail(node);
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            // 直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
            if (get(key) != -1) {
                map.get(key).val = value;
                return;
            }

            // 不存在，新增，新增后判断容量是否超出，超出需要删除头结点
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            moveToTail(node);

            if (map.size() > capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
        }

        /**
         * 移动到链尾
         *
         * @param node
         */
        public void moveToTail(ListNode node) {
            node.pre = tail.pre;
            tail.pre = node;
            node.pre.next = node;
            node.next = tail;
        }

        private class ListNode {
            int key;
            int val;
            ListNode pre;
            ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
                pre = null;
                next = null;
            }
        }
    }
}