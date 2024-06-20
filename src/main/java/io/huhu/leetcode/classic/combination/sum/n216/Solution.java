package io.huhu.leetcode.classic.combination.sum.n216;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/combination-sum-iii/description/">Combination Sum III</a>
 * </h1>
 * <p>
 * Find all valid combinations of k numbers that sum up to n such the following conditions are true:
 * </p>
 * <ul>
 * <li>Only numbers 1 through 9 are used.</li>
 * <li>Each number is used at most once.</li>
 * </ul>
 * <p>
 * Return all list of possible valid combinations.
 * The list must not contain the same combination twice,
 * and the combinations may returned in any order.
 * </p>
 */
class Solution {

    /**
     * <ul>
     * <li>2 <= k <= 9</li>
     * <li>1 <= n <= 60</li>
     * </ul>
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrace(int j, int k, int n, List<Integer> path, List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (k < 0) {
            return;
        }
        for (int i = j; i <= n && i <= 9; i++) {
            path.addLast(i);
            backtrace(i + 1, k - 1, n - i, path, result);
            path.removeLast();
        }
    }

}
