package io.huhu.leetcode.bit.manipulation.easy.n222;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/description/">完全二叉树的节点个数</a>
 */
class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 求树的高度
        int h = 0;
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            h++;
        }
        // 节点数在 2^h 到 2^(h+1) - 1 范围内
        int l = 1 << h, r = (1 << (h + 1)) - 1;
        // 二分查找判断节点是否存在
        while (l < r) {
            int m = (l + r + 1) >> 1;
            if (exists(root, h, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    /**
     * 根据数值的最后一位判断是选择左节点还是右节点
     */
    private boolean exists(TreeNode root, int h, int m) {
        int k = 1 << (h - 1);
        TreeNode node = root;
        while (node != null && k > 0) {
            node = (m & k) == 0 ? node.left : node.right;
            k >>= 1;
        }
        return node != null;
    }

}
