package io.huhu.leetcode.binary.tree.hard.n968;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-cameras/description/">
 * Binary Tree Cameras
 * </a>
 */
class Solution {

    private int ans;

    public int minCameraCover(TreeNode root) {
        if (f(root) == 0) {
            ans++;
        }
        return ans;
    }

    /**
     * status = 0: no cover & no camera
     * status = 1:  covered & no camera
     * status = 2:  covered & camera
     */
    private int f(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int l = f(root.left);
        int r = f(root.right);
        if (l == 0 || r == 0) {
            ans++;
            return 2;
        }
        if (l == 1 && r == 1) {
            return 0;
        }
        return 1;
    }

}
