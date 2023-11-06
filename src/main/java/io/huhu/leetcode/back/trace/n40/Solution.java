package io.huhu.leetcode.back.trace.n40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/combination-sum-ii/description/">40.组合总和II</a></h1>
 * 给定一个候选人编号的组合candidates和一个目标数target, 找出candidates中所有可以使数字和为target的组合.
 * <br/>
 * candidates中每个数字在每个组合中只能使用一次.
 * <br/>
 * 注意: 解集不能包含重复的组合
 */
class Solution {

    /**
     * 1 <= candidates.length <= 100
     * <br/>
     * 1 <= candidates[i] <= 50
     * <br/>
     * 1 <= target <= 30
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backTrace(candidates, 0, target, new ArrayDeque<>(), result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrace(int[] candidates, int i, int target, Deque<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (target < candidates[j]) {
                return;
            }
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            path.addLast(candidates[j]);
            backTrace(candidates, j + 1, target - candidates[j], path, result);
            path.removeLast();
        }
    }

}
