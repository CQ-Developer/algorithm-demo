package io.huhu.leetcode.back.trace.n357;

/**
 * <a href="https://leetcode.cn/problems/count-numbers-with-unique-digits/description/">
 * 357.统计各位数字都不同的数字个数
 * </a>
 * 给你一个整数n, 统计并返回给位数字都不同的数字x的个数, 其中 0 <= x < 10^n
 */
class Solution {

    /**
     * 0 <= n <= 8
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] result = {0};
        for (int i = n; i > 0; i--) {
            dfs(i, new boolean[10], 0, result);
        }
        return result[0] + 1;
    }

    /**
     * 回溯算法
     */
    private void dfs(int n, boolean[] used, int path, int[] result) {
        if (n == path) {
            result[0]++;
            return;
        }
        for (int i = 9; i >= 0; i--) {
            if (used[i]) {
                continue;
            }
            if (path == 0 && i == 0) {
                return;
            }
            used[i] = true;
            dfs(n, used, path + 1, result);
            used[i] = false;
        }
    }

}
