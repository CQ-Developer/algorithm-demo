package io.huhu.leetcode.back.trace.n526;

/**
 * <a href="https://leetcode.cn/problems/beautiful-arrangement/">526.优美的排列</a>
 * 假设有从1到n的n个整数. 用这些整数构造一个数组perm(下标从1开始), 只要满足下述条件之一, 该数组就是一个优美的排列:
 * perm[i]能够被i整除
 * i能够被perm[i]整除
 * 给你一个整数n, 返回可以构造的优美排列的数量.
 */
class Solution {

    int cnt;

    /**
     * 1 <= n <= 15
     */
    public int countArrangement(int n) {
        dfs(n, 1, new boolean[n]);
        return cnt;
    }

    /**
     * 深度优先遍历
     */
    private int dfs(int n, int i, boolean[] used) {
        if (i > n) {
            return 1;
        }
        for (int j = 1; j <= n; j++) {
            if (used[j - 1]) {
                continue;
            }
            if (j % i != 0 && i % j != 0) {
                continue;
            }
            used[j - 1] = true;
            if (1 == dfs(n, i + 1, used)) {
                cnt++;
            }
            used[j - 1] = false;
        }
        return 0;
    }

}
