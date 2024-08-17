package io.huhu.leetcode.binary.tree.easy.n111;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/">
 * Minimum Depth of Binary Tree
 * </a>
 */
class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if (root.left != null) {
            ans = Math.min(ans, minDepth(root.left));
        }
        if (root.right != null) {
            ans = Math.min(ans, minDepth(root.right));
        }
        return ans + 1;
    }

}
