package io.huhu.leetcode.back.trace.n216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii/description/">216.组合总和II</a>
 * 找出所有相加之和为n的k个数的组合, 且满足下列条件:
 * ~ 只使用数字1到9
 * ~ 每个数字最多使用一次
 * 返回所有可能的有效组合的列表.
 * 该列表不能包含相同的组合两次, 组合可以以任何顺序返回.
 */
class Solution {

    /**
     * 2 <= k <= 9
     * 1 <= n <= 60
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(n, 1, k, 0, new ArrayDeque<>(), result);
        return result;
    }

    /**
     * 回溯
     * 剪枝条件一: j + sum <= n
     *      解释: j是递增的, 如果 j + sum == n 那么没必要再进行下一轮循环了, 因为结果sum必定大于n
     * 剪枝条件二: k - path.size() <= 9 - j + 1
     *      解释: 剩余的数字已经不可能凑齐k个数了
     */
    private void backTrace(int n, int i, int k, int sum, Deque<Integer> path, List<List<Integer>> result) {
        if (k == path.size()) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int j = i; j <= 9 && j + sum <= n && k - path.size() <= 10 - j; j++) {
            path.addLast(j);
            backTrace(n, j + 1, k, sum + j, path, result);
            path.removeLast();
        }
    }

}
