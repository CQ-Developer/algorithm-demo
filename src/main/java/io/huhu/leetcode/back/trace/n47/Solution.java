package io.huhu.leetcode.back.trace.n47;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/permutations-ii/">47.全排列II</a></h1>
 * 给定一个可包含重复数字的序列nums, 按任意顺序返回所有不重复的全排列.
 */
class Solution {

    /**
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrace(nums, new boolean[nums.length], new ArrayDeque<>(), result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrace(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backTrace(nums, used, path, result);
            path.removeLast();
            used[i] = false;
        }
    }

}
