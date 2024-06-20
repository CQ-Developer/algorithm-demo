package io.huhu.leetcode.classic.combination.sum.n39;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/description/">Combination Sum</a>
 */
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(candidates, 0, new ArrayList<>(), target, ans);
        return ans;
    }

    private void backtrace(int[] candidates, int j, List<Integer> path, int target, List<List<Integer>> ans) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = j; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backtrace(candidates, i, path, target - candidates[i], ans);
            path.removeLast();
        }
    }

}
