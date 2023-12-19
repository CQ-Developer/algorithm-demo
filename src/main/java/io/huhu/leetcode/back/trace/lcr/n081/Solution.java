package io.huhu.leetcode.back.trace.lcr.n081;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/Ygoe9J/description/">组合总和</a>
 * <p>给定一个无重复元素的正整数数组candidates和一个正整数target, 找出candidates中所有可以使数字和为目标数target的唯一组合
 * <p>candidates中的数字可以无限制重复被选取. 如果至少一个所选数字数量不同, 则两种组合是不同的.
 * <p>对于给定的输入, 保证和为target的唯一组合数少于150个
 * <p>提示:
 * <li>1 <= candidates.length <= 30
 * <li>1 <= candidates[i] <= 200
 * <li>candidates中的每个元素都是独一无二的
 * <li>1 <= target <= 500
 */
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTracing(candidates, 0, target, new ArrayDeque<>(), res);
        return res;
    }

    private void backTracing(int[] candidates, int idx, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length && candidates[i] <= target; i++) {
            path.addLast(candidates[i]);
            backTracing(candidates, i, target - candidates[i], path, res);
            path.removeLast();
        }
    }

}
