package io.huhu.leetcode.back.trace.n39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/combination-sum/">39.组合总和</a></h1>
 * 给你一个无重复元素的整数数组candidates和一个目标整数target,
 * 找出candidates中可以使数字和为目标数target的所有不同组合,
 * 并以列表形式返回. 你可以按任意顺序返回这些组合.
 * <br/>
 * candidates中的同一个数字可以无限制重复被选取.
 * 如果至少一个数字的被选数量不同, 则两种组合是不同的.
 * <br/>
 * 对于给定的输入, 保证和为target的不同组合数少于150个.
 */
class Solution {

    /**
     * 1 <= candidates.length <= 30
     * <br/>
     * 2 <= candidates[i] <= 40
     * <br/>
     * candidates的所有元素互不相同
     * <br/>
     * 1 <= target <= 40
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates, 0, target, new ArrayDeque<>(), result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrack(int[] candidates, int i, int target, Deque<Integer> path, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            path.addLast(candidates[j]);
            backTrack(candidates, j, target - candidates[j], path, result);
            path.removeLast();
        }
    }

}
