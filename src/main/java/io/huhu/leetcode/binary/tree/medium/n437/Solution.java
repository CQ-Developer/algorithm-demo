package io.huhu.leetcode.binary.tree.medium.n437;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/path-sum-iii/description/">
 * Path Sum III
 * </a>
 */
class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> pre = new HashMap<>();
        pre.put(0L, 1);
        return f(root, targetSum, 0L, pre);
    }

    private int f(TreeNode root, int target, long sum, Map<Long, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int ans = preSum.getOrDefault(sum - target, 0);
        preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        ans += f(root.left, target, sum, preSum);
        ans += f(root.right, target, sum, preSum);
        preSum.put(sum, preSum.get(sum) - 1);
        return ans;
    }

}
