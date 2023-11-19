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
        return dfs(n, 0, new boolean[10]);
    }

    /**
     * 回溯算法
     */
    private int dfs(int n, int j, boolean[] used) {
        int cnt = 0;
        for (int i = 0; i < 10 && j != n; i++) {
            // 剪枝1: used[i]
            // 不能使用已经用过的数字
            // 剪枝2: i == 0 && n > 1 && j == 1
            // 第一位数字不能为0
            if (!(used[i] || i == 0 && n > 1 && j == 1)) {
                used[i] = true;
                cnt += dfs(n, j + 1, used) + 1;
                used[i] = false;
            }
        }
        return cnt;
    }

}
