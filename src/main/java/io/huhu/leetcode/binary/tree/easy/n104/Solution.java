package io.huhu.leetcode.binary.tree.easy.n104;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/">
 * Maximum Depth of Binary Tree
 * </a>
 */
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
