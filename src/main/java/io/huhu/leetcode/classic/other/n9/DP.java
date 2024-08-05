package io.huhu.leetcode.classic.other.n9;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1776">宝物筛选</a>
 */
class DP {

    static final int MAXN = 1001;
    static final int MAXW = 40001;

    static final int[] V = new int[MAXN];
    static final int[] W = new int[MAXN];
    static final int[] dp = new int[MAXW];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), t = sc.nextInt();
        int m = 0;
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt(), w = sc.nextInt(), c = sc.nextInt();
            for (int k = 1; k <= c; k <<= 1) {
                V[++m] = k * v;
                W[m] = k * w;
                c -= k;
            }
            if (c > 0) {
                V[++m] = c * v;
                W[m] = c * w;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = t; j >= W[i]; j--) {
                dp[j] = Integer.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }
        System.out.println(dp[t]);
    }

}
