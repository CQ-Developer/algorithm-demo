package io.huhu.leetcode.binary.tree.medium.n105;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">
 * Construct Binary Tree from Preorder and Inorder Traversal
 * </a>
 */
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode f(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, Map<Integer, Integer> map) {
        if (l1 > r1) {
            return null;
        }
        if (l1 == r1) {
            return new TreeNode(preorder[l1]);
        }
        TreeNode root = new TreeNode(preorder[l1]);
        int i = map.get(preorder[l1]);
        root.left = f(preorder, l1 + 1, l1 + i - l2, inorder, l2, i - 1, map);
        root.right = f(preorder, l1 + i - l2 + 1, r1, inorder, i + 1, r2, map);
        return root;
    }

}
