package io.huhu.leetcode.n1372;

import io.huhu.AC;

@AC
class DepthFirstSearch implements Code {

    private int ans;

    @Override
    public int longestZigZag(TreeNode root) {
        f(root, 0, 0);
        return ans;
    }

    private void f(TreeNode node, int l, int r) {
        ans = Math.max(ans, Math.max(l, r));
        if (node == null) {
            return;
        }
        if (node.left != null) {
            f(node.left, r + 1, 0);
        }
        if (node.right != null) {
            f(node.right, 0, l + 1);
        }
    }

}
