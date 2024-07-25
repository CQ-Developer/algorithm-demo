package io.huhu.leetcode.dynamic.programming.medium.n494;

import java.util.HashMap;
import java.util.Map;

class DFS implements Solution {

    @Override
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target, new HashMap<>());
    }

    private int dfs(int[] nums, int i, int j, Map<Integer, Map<Integer, Integer>> mem) {
        if (i == nums.length) {
            return j == 0 ? 1 : 0;
        }
        if (mem.containsKey(i) && mem.get(i).containsKey(j)) {
            return mem.get(i).get(j);
        }
        int ans = dfs(nums, i + 1, j + nums[i], mem) + dfs(nums, i + 1, j - nums[i], mem);
        mem.putIfAbsent(i, new HashMap<>());
        mem.get(i).put(j, ans);
        return ans;
    }

}
