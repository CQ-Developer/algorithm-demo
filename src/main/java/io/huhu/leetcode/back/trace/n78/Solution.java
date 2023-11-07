package io.huhu.leetcode.back.trace.n78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/subsets/">78.子集</a></h1>
 * 给你一个整数数组nums, 数组中的元素互不相同. 返回该数组所有可能的子集(幂集).
 * 解集不能包含重复的子集. 你可以按任意顺序返回解集.
 */
class Solution {

    /**
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums中的元素不互相同
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of());
        for (int i = 0; i < nums.length; i++) {
            backTrace(nums, 0, i + 1, new ArrayDeque<>(), result);
        }
        return result;
    }

    /**
     * 回溯算法
     * 剪枝条件: {@code j < nums.length - (cnt - path.size()) + 1}
     */
    private void backTrace(int[] nums, int i, int cnt, Deque<Integer> path, List<List<Integer>> result) {
        if (cnt == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < nums.length - cnt + path.size() + 1; j++) {
            path.addLast(nums[j]);
            backTrace(nums, j + 1, cnt, path, result);
            path.removeLast();
        }
    }

}
