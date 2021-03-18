//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 98 👎 0

package com.cute.leetcode.editor.cn;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class ErChaShuDeShenDuLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaShuDeShenDuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // 后序遍历（DFS）递归实现。
        /*if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;*/

        // 层序遍历（BFS） 队列 实现
        if (root == null)
            return 0;
        List<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        List<TreeNode> tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList();
            for (TreeNode node : queue) {
                if (node.left != null)
                    tmp.add(node.left);
                if (node.right != null)
                    tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}