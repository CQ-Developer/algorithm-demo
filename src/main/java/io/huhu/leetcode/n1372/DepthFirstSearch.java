package io.huhu.leetcode.n1372;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int longestZigZag(TreeNode root) {
        return f(root, 0) - 1;
    }

    /**
     * dir = 0: left or right
     * dir = 1: left
     * dir = 2: right
     */
    private int f(TreeNode node, int dir) {
        if (node == null) {
            return 0;
        }
        int ans;
        if (dir == 0) {
            ans = Math.max(f(node.left, 2), f(node.right, 1)) + 1;
            ans = Math.max(ans, Math.max(f(node.left, 0), f(node.right, 0)));
        } else {
            ans = dir == 1 ? f(node.left, 2) + 1 : f(node.right, 1) + 1;
        }
        return ans;
    }

}
