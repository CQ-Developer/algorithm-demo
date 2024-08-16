package io.huhu.leetcode.binary.tree.medium.n102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">
 * Binary Tree Level Order Traversal
 * </a>
 */
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> list = new ArrayList<>();
            while (n-- > 0) {
                TreeNode cur = deque.removeFirst();
                list.add(cur.val);
                if (cur.left != null) {
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    deque.addLast(cur.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

}
