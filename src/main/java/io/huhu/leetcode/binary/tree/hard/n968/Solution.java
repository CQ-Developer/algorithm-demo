package io.huhu.leetcode.binary.tree.hard.n968;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-cameras/description/">
 * Binary Tree Cameras
 * </a>
 */
class Solution {

    public int minCameraCover(TreeNode root) {
        Info info = f(root);
        return info.status == 0 ? info.camera + 1 : info.camera;
    }

    /**
     * <li>status = 0: no cover & no sum</li>
     * <li>status = 1: covered & no sum</li>
     * <li>status = 2: covered & sum</li>
     */
    private Info f(TreeNode root) {
        if (root == null) {
            return new Info(1, 0);
        }
        Info l = f(root.left), r = f(root.right);
        int sum = l.camera + r.camera;
        if (l.status == 0 || r.status == 0) {
            return new Info(2, sum + 1);
        }
        if (l.status == 1 && r.status == 1) {
            return new Info(0, sum);
        }
        return new Info(1, sum);
    }

    class Info {

        final int status;
        final int camera;

        Info(int status, int camera) {
            this.status = status;
            this.camera = camera;
        }

    }

}
