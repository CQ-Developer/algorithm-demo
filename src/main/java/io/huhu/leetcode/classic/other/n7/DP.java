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
        int[] dp = new int[m + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k < size[i]; k++) {
                    if (j - w[group[i][k]] >= 0) {
                        dp[j] = Integer.max(dp[j], dp[j - w[group[i][k]]] + v[group[i][k]]);
                    }
                }
            }
        }
        System.out.println(dp[m]);
    }

}
