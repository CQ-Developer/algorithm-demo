package io.huhu.leetcode.binary.tree.medium.n235;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">
 * Lowest Common Ancestor of a Binary Search Tree
 * </a>
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (p.val != root.val && q.val != root.val) {
            if (Math.min(q.val, p.val) < root.val && Math.max(q.val, p.val) > root.val) {
                break;
            }
            root = root.val < Math.min(q.val, p.val) ? root.right : root.left;
        }
        return root;
    }

}
