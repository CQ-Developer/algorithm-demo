package io.huhu.leetcode.binary.tree.medium.n333;

/**
 * <a href="https://leetcode.cn/problems/largest-bst-subtree/description/">
 * Largest BST Subtree
 * </a>
 */
class Solution {

    static class Info {

        final boolean isBST;
        final int maxBSTSize;
        final long max;
        final long min;

        Info(boolean isBST, int maxBSTSize, long max, long min) {
            this.isBST = isBST;
            this.maxBSTSize = maxBSTSize;
            this.max = max;
            this.min = min;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        return f(root).maxBSTSize;
    }

    private Info f(TreeNode cur) {
        if (cur == null) {
            return new Info(true, 0, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        Info left = f(cur.left);
        Info right = f(cur.right);
        long max = Math.max(cur.val, Math.max(left.max, right.max));
        long min = Math.min(cur.val, Math.min(left.min, right.min));
        boolean isBST = left.isBST && right.isBST && cur.val < right.min && cur.val > left.max;
        int maxBSTSize;
        if (isBST) {
            maxBSTSize = left.maxBSTSize + right.maxBSTSize + 1;
        } else {
            maxBSTSize = Math.max(left.maxBSTSize, right.maxBSTSize);
        }
        return new Info(isBST, maxBSTSize, max, min);
    }

}
