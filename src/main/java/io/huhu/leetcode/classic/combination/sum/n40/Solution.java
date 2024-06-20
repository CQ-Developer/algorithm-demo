package io.huhu.leetcode.classic.combination.sum.n40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/description/">Combination Sum II</a>
 */
class Solution {

    /**
     * 1 <= candidates.length <= 100
     * 1 <= candidates[i] <= 50
     * 1 <= target <= 30
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(candidates, 0, new ArrayList<>(), target, ans);
        return ans;
    }

    private void backtrace(int[] candidates, int j, List<Integer> path, int target, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = j; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > j && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.addLast(candidates[i]);
            backtrace(candidates, i + 1, path, target - candidates[i], ans);
            path.removeLast();
        }
    }

}
