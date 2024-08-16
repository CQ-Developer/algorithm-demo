package io.huhu.leetcode.binary.tree.medium.n103;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/">
 * Binary Tree Zigzag Level Order Traversal
 * </a>
 */
class Solution {

    static final TreeNode[] queue = new TreeNode[2001];

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        boolean reverse = true;
        int l = 0, r = 0;
        queue[r++] = root;
        while (l < r) {
            int n = r - l;
            List<Integer> list = new ArrayList<>();
            for (int k = 0, i = reverse ? l : r - 1, j = reverse ? 1 : -1; k < n; k++, i += j) {
                list.add(queue[i].val);
            }
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue[l++];
                if (cur.left != null) {
                    queue[r++] = cur.left;
                }
                if (cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
            ans.add(list);
            reverse = !reverse;
        }
        return ans;
    }

}
