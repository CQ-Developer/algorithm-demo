package io.huhu.leetcode.back.trace.lcr.n082;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/4sjJUc/description/">组合总和II</a>
 * <p>给定一个可能有重复数字的整数数组candidates和一个目标数target,
 * 找出candidates中所有可以使数字和为target的组合.
 * <p>candidates中每个数字在每个组合中只能使用一次, 解集不能包含重复的组合.
 * <p>提示:
 * <li>1 <= candidates.length <= 100
 * <li>1 <= candidates[i] <= 50
 * <li>1 <= target <= 30
 */
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTracing(candidates, 0, target, new ArrayDeque<>(), res);
        return res;
    }

    private void backTracing(int[] candidates, int j, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = j; i < candidates.length && candidates[i] <= target; i++) {
            if (i > j && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            backTracing(candidates, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }

}
