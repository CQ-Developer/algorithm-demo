package io.huhu.leetcode.binary.tree.medium.n102;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">
 * Binary Tree Level Order Traversal
 * </a>
 */
class Solution {

    static final TreeNode[] queue = new TreeNode[20001];

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int l = 0, r = 0;
        queue[r++] = root;
        while (l < r) {
            int n = r - l;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue[l++];
                list.add(cur.val);
                if (cur.left != null) {
                    queue[r++] = cur.left;
                }
                if (cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
            ans.add(list);
        }
        return ans;
    }

}
