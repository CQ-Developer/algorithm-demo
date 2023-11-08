package io.huhu.leetcode.back.trace.n90;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/subsets-ii/description/">90.子集II</a></h1>
 * 给你一个整数数组nums, 其中可能包含重复元素, 请你返回该数组所有可能的子集(幂集).
 * 解集不能包含重复子集. 返回的解集中, 子集可以按任意顺序排列.
 */
class Solution {

    /**
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            backTrace(nums, 0, i + 1, new ArrayDeque<>(), result);
        }
        return result;
    }

    /**
     * 回溯算法
     * 选择条件: cnt == path.size()
     * 剪枝条件: nums.length - (cnt - path.size()) + 1
     * 去重条件: j > i && nums[j] == nums[j - 1]
     */
    private void backTrace(int[] nums, int i, int cnt, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == cnt) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < nums.length - cnt + path.size() + 1; j++) {
            if (j == i || nums[j] != nums[j - 1]) {
                path.addLast(nums[j]);
                backTrace(nums, j + 1, cnt, path, result);
                path.removeLast();
            }
        }
    }

}
