package io.huhu.leetcode.n1372;

import io.huhu.TLE;

@TLE
class DepthFirstSearch implements Code {

    @Override
    public int longestZigZag(TreeNode root) {
        return f(root, 0) - 1;
    }

    private int f(TreeNode node, int dir) {
        if (node == null) {
            return 0;
        }
        int ans;
        if (dir == 0) {
            int a = Math.max(f(node.left, 2), f(node.right, 1)) + 1;
            int b = Math.max(a, Math.max(f(node.left, 0), f(node.right, 0)));
            ans = Math.max(a, b);
        } else {
            ans = dir == 1 ? f(node.left, 2) + 1 : f(node.right, 1) + 1;
        }
        return ans;
    }

}
