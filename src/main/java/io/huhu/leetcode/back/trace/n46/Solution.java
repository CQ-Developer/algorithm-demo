package io.huhu.leetcode.back.trace.n46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/permutations/description/">46.全排列</a></h1>
 * 给定一个不含重复数字的数组nums, 返回其所有可能的全排列.
 * 你可以按任意顺序返回答案.
 */
class Solution {

    /**
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums中的所有整数互不相同
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
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
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                backTrace(nums, used, path, result);
                path.removeLast();
                used[i] = false;
            }
        }
    }

}
