package io.huhu.leetcode.back.trace.n526;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/beautiful-arrangement/">526.优美的排列</a>
 * 假设有从1到n的n个整数. 用这些整数构造一个数组perm(下标从1开始), 只要满足下述条件之一, 该数组就是一个优美的排列:
 * perm[i]能够被i整除
 * i能够被perm[i]整除
 * 给你一个整数n, 返回可以构造的优美排列的数量.
 */
class Solution {

    /**
     * 1 <= n <= 15
     */
    public int countArrangement(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(n, new boolean[n], new ArrayDeque<>(), result);
        return result.size();
    }

    private void backTrace(int n, boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            int a = i + 1;
            int b = path.size() + 1;
            if (a % b != 0 && b % a != 0) {
                continue;
            }
            used[i] = true;
            path.addLast(a);
            backTrace(n, used, path, result);
            path.removeLast();
            used[i] = false;
        }
    }

}
