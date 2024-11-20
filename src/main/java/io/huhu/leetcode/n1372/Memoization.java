package io.huhu.leetcode.n1372;

import io.huhu.AC;

import java.util.HashMap;
import java.util.Map;

@AC
class Memoization implements Code {

    @Override
    public int longestZigZag(TreeNode root) {
        return f(root, 0, new HashMap<>()) - 1;
    }

    private int f(TreeNode node, int dir, Map<TreeNode, Map<Integer, Integer>> mem) {
        if (node == null) {
            return 0;
        }
        if (mem.containsKey(node) && mem.get(node).containsKey(dir)) {
            return mem.get(node).get(dir);
        }
        int ans;
        if (dir == 0) {
            ans = Math.max(f(node.left, 2, mem), f(node.right, 1, mem)) + 1;
            ans = Math.max(ans, Math.max(f(node.left, 0, mem), f(node.right, 0, mem)));
        } else {
            ans = dir == 1 ? f(node.left, 2, mem) + 1 : f(node.right, 1, mem) + 1;
        }
        if (!mem.containsKey(node)) {
            mem.put(node, new HashMap<>());
        }
        mem.get(node).put(dir, ans);
        return ans;
    }

}
