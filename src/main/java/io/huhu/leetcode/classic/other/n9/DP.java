package io.huhu.leetcode.classic.other.n9;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1776">宝物筛选</a>
 */
class DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), W = sc.nextInt();
        int[] v = new int[n], w = new int[n], m = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            m[i] = sc.nextInt();
        }
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = W; j >= 0; j--) {
                for (int k = 1; k <= m[i] && j >= w[i] * k; k++) {
                    dp[j] = Integer.max(dp[j], dp[j - w[i] * k] + v[i] * k);
                }
            }
        }
        System.out.println(dp[W]);
    }

}
