package io.huhu.leetcode.binary.tree.hard.n1373;

/**
 * <a href="https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/description/">
 * Maximum Sum BST in Binary Tree
 * </a>
 */
class Solution {

    static class Info {

        final boolean isBST;
        final int sum;
        final int max;
        final int min;

        Info(boolean isBST, int sum, int max, int min) {
            this.isBST = isBST;
            this.sum = sum;
            this.max = max;
            this.min = min;
        }

    }

    public int maxSumBST(TreeNode root) {
        return f(root).sum;
    }

    private Info f(TreeNode root) {
        if (root == null) {
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Info left = f(root.left);
        Info right = f(root.right);
        int max = Math.max(root.val, Math.max(left.max, right.max));
        int min = Math.min(root.val, Math.min(left.min, right.min));
        boolean isBST = left.isBST && right.isBST && root.val > left.max && root.val < right.min;
        int sum;
        if (isBST) {
            sum = left.sum + right.sum + root.val;
        } else {
            sum = Math.max(left.sum, right.sum);
        }
        return new Info(isBST, sum, max, min);
    }

}
