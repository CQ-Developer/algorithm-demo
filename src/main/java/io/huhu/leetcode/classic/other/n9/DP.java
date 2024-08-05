package io.huhu.leetcode.classic.other.n9;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1776">宝物筛选</a>
 */
class DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), W = sc.nextInt();
        int[] v = new int[n + 1], w = new int[n + 1], m = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            m[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= m[i]; k++) {
                    if (j - w[i] * k >= 0) {
                        dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j - w[i] * k] + v[i] * k);
                    }
                }
            }
        }
        System.out.println(dp[n][W]);
    }

}
