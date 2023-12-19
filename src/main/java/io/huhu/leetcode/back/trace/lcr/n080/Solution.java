package io.huhu.leetcode.back.trace.lcr.n080;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/uUsW3B/description/">组合</a>
 * <p>给定两个整数n和k, 返回1...n中所有可能的k个数的组合.
 * <p>提示:
 * <li>1 <= n <= 20
 * <li>1 <= k <= n
 */
class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTracing(n + 1, 1, k, new ArrayDeque<>(), res);
        return res;
    }

    private void backTracing(int n, int i, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < n && j <= n + path.size() - k; j++) {
            path.addLast(j);
            backTracing(n, j + 1, k, path, res);
            path.removeLast();
        }
    }

}
