package io.huhu.leetcode.dynamic.programming.hard.n1434;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/number-of-ways-to-wear-different-hats-to-each-other/description/">
 * Number of Ways to Wear Different Hats to Each Other
 * </a>
 */
class Solution {

    private static final int M = 1000000007;

    public int numberWays(List<List<Integer>> hats) {
        int m = 0;
        for (var hat : hats) {
            for (int h : hat) {
                m = Math.max(m, h);
            }
        }
        int n = hats.size();
        int[] satisfies = new int[m + 1];
        for (int p = 0; p < n; p++) {
            for (int h : hats.get(p)) {
                satisfies[h] |= (1 << p);
            }
        }
        int[][] dp = new int[1 << n][m + 1];
        for (var a : dp) {
            Arrays.fill(a, -1);
        }
        return f(satisfies, n, m, 0, 1, dp);
    }

    private int f(int[] satisfies, int n, int m, int status, int i, int[][] dp) {
        if (status == (1 << n) - 1) {
            return 1;
        }
        if (i > m) {
            return 0;
        }
        if (dp[status][i] != -1) {
            return dp[status][i];
        }
        int ans = f(satisfies, n, m, status, i + 1, dp);
        int p = satisfies[i];
        while (p != 0) {
            // 从右向左依次取出当前帽子能满足的人
            int j = p & -p;
            if ((status & j) == 0) {
                ans = (ans + f(satisfies, n, m, status | j, i + 1, dp)) % M;
            }
            p ^= j;
        }
        return dp[status][i] = ans;
    }

}
