package io.huhu.leetcode.back.trace.n77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <h1><a href="https://leetcode.cn/problems/combinations/description/">77.组合</a></h1>
 * 给定两个整数n和k, 返回范围[1,n]中所有可能的k个数的组合.
 * 你可以按任何顺序返回答案.
 */
class Solution {

    /**
     * 1 <= n <= 20
     * 1 <= k <= n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(1, n, k, new ArrayDeque<>(), result);
        return result;
    }

    /**
     * 回溯算法
     */
    private void backTrace(int i, int n, int k, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j <= n - k + path.size() + 1; j++) {
            path.addLast(j);
            backTrace(j + 1, n, k, path, result);
            path.removeLast();
        }
    }

}
