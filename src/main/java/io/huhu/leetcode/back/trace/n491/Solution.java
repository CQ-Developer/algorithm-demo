package io.huhu.leetcode.back.trace.n491;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/non-decreasing-subsequences/description/">491.递增子序列</a>
 * 给你一个整数数组nums, 找出并返回所有该数组中不同的递增子序列, 递增子序列中至少有两个元素.
 * 你可以按任意顺序返回答案.
 * 数组中可能含有重复元素, 如出现两个整数相等, 也可以视作递增序列的一种特殊情况.
 */
class Solution {

    /**
     * 1 <= nums.length <= 15
     * -100 <= nums[i] <= 100
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, 0, new ArrayDeque<>(), result);
        return new ArrayList<>(result);
    }

    /**
     * 深度优先遍历
     */
    private void dfs(int[] nums, int j, Deque<Integer> path, Set<List<Integer>> result) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }
        for (int i = j; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.peekLast()) {
                continue;
            }
            path.offerLast(nums[i]);
            dfs(nums, i + 1, path, result);
            path.pollLast();
        }
    }

}
