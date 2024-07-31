package io.huhu.leetcode.classic.other.n7;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1757">
 * 分组背包
 * </a>
 */
public class DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[] w = new int[n], v = new int[n], g = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
            g[i] = sc.nextInt();
            len = Integer.max(len, g[i]);
        }
        int[] size = new int[len + 1];
        int[][] group = new int[len + 1][n];
        for (int i = 0; i < n; i++) {
            group[g[i]][size[g[i]]++] = i;
        }
        int[][] dp = new int[len + 1][m + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < size[i]; k++) {
                    int l = group[i][k];
                    if (j - w[l] >= 0) {
                        dp[i][j] = Integer.max(dp[i][j], dp[i - 1][j - w[l]] + v[l]);
                    }
                }
            }
        }

        System.out.println(dp[len][m]);
    }

}
