package io.huhu.leetcode.binary.tree.medium.n958;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/">
 * Check Completeness of a Binary Tree
 * </a>
 */
class Solution {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean f = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if ((cur.left == null && cur.right != null) || (f && (cur.left != null || cur.right != null))) {
                return false;
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (cur.left == null || cur.right == null) {
                f = true;
            }
        }
        return true;
    }

}
