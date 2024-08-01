package io.huhu.leetcode.classic.other.n8;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1616">疯狂的采药</a>
 */
class DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[] t = new int[n + 1], v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - t[i] >= 0) {
                    dp[i][j] = Long.max(dp[i][j], dp[i][j - t[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }

}
