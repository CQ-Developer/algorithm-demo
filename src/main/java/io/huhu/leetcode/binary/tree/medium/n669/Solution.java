package io.huhu.leetcode.binary.tree.medium.n669;

/**
 * <a href="https://leetcode.cn/problems/trim-a-binary-search-tree/description/">
 * Trim a Binary Search Tree
 * </a>
 */
class Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // root...low...high
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        // low...high...root
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        // low...root...high
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

}
