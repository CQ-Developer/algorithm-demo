package io.huhu.leetcode.binary.tree.medium.n98;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/">
 * Validate Binary Search Tree
 * </a>
 */
class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode cur, long min, long max) {
        if (cur == null) {
            return true;
        }
        if (cur.val <= min || cur.val >= max) {
            return false;
        }
        return isValidBST(cur.left, min, cur.val) && isValidBST(cur.right, cur.val, max);
    }

}
