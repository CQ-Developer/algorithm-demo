package io.huhu.leetcode.dynamic.programming.easy.bytedance.n006;

import java.util.Scanner;

/**
 * <a href="https://leetcode.cn/problems/tJau2o/">
 * 夏季特惠
 * </a>
 */
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        int n = sc.nextInt(), x = sc.nextInt(), m = 0;
        int[] cost = new int[n];
        long[] value = new long[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            long w = sc.nextLong();
            int well = a - b - b;
            if (well >= 0) {
                x += well;
                ans += w;
            } else {
                cost[m] = -well;
                value[m++] = w;
            }
        }
        long[] dp = new long[x + 1];
        for (int i = 0; i < m; i++) {
            for (int j = x; j >= cost[i]; j--) {
                dp[j] = Long.max(dp[j], dp[j - cost[i]] + value[i]);
            }
        }
        System.out.println(ans + dp[x]);
    }

}
