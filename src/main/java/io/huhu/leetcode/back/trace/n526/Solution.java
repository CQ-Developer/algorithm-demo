package io.huhu.leetcode.back.trace.n526;

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
        int[] result = {0};
        dfs(n, new boolean[n], 1, result);
        return result[0];
    }

    /**
     * 回溯算法
     */
    private void dfs(int n, boolean[] used, int b, int[] result) {
        if (b > n) {
            result[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            int a = i + 1;
            if (a % b != 0 && b % a != 0) {
                continue;
            }
            used[i] = true;
            dfs(n, used, b + 1, result);
            used[i] = false;
        }
    }

}
