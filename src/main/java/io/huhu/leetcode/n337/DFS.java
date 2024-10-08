package io.huhu.leetcode.n337;

import java.util.HashMap;
import java.util.Map;

class DFS implements Code {

    @Override
    public int rob(TreeNode root) {
        return f(root, new HashMap<>());
    }

    private int f(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        int ans = node.val;
        if (node.left != null) {
            ans += f(node.left.left, map) + f(node.left.right, map);
        }
        if (node.right != null) {
            ans += f(node.right.left, map) + f(node.right.right, map);
        }
        ans = Math.max(ans, f(node.left, map) + f(node.right, map));
        map.put(node, ans);
        return ans;
    }

}
