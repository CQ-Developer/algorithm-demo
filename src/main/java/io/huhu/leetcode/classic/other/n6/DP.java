package io.huhu.leetcode.classic.other.n6;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1064">
 * 金明的预算方案
 * </a>
 */
class DP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = scanner.nextInt(), n = scanner.nextInt();
        int[] price = new int[n + 1], value = new int[n + 1], size = new int[n + 1];
        boolean[] primary = new boolean[n + 1];
        int[][] attachment = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            price[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
            int q = scanner.nextInt();
            value[i] *= price[i];
            primary[i] = q == 0;
            if (q != 0) {
                attachment[q][size[q]++] = i;
            }
        }
        int[] dp = new int[budget + 1];
        for (int i = 1; i <= n; i++) {
            if (primary[i]) {
                for (int j = dp.length - 1; j >= price[i]; j--) {
                    dp[j] = Integer.max(dp[j], dp[j - price[i]] + value[i]);
                    int a = size[i] >= 1 ? attachment[i][0] : -1;
                    int b = size[i] >= 2 ? attachment[i][1] : -1;
                    if (a != -1 && j - price[i] - price[a] >= 0) {
                        dp[j] = Integer.max(dp[j], dp[j - price[i] - price[a]] + value[i] + value[a]);
                    }
                    if (b != -1 && j - price[i] - price[b] >= 0) {
                        dp[j] = Integer.max(dp[j], dp[j - price[i] - price[b]] + value[i] + value[b]);
                    }
                    if (a != -1 && b != -1 && j - price[i] - price[a] - price[b] >= 0) {
                        dp[j] = Integer.max(dp[j], dp[j - price[i] - price[a] - price[b]] + value[i] + value[a] + value[b]);
                    }
                }
            }
        }
        System.out.println(dp[budget]);
    }

}
