package io.huhu.leetcode.classic.other.n8;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1616">疯狂的采药</a>
 */
class DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[] t = new int[n], v = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        long[] dp = new long[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = t[i]; j <= m; j++) {
                dp[j] = Long.max(dp[j], dp[j - t[i]] + v[i]);
            }
        }
        System.out.println(dp[m]);
    }

}
