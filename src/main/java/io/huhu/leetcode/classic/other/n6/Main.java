package io.huhu.leetcode.classic.other.n6;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1064">
 * 金明的预算方案
 * </a>
 */
class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n -> 预算
        int n = scanner.nextInt(), m = scanner.nextInt();
        // v -> 价格
        // p -> 重要度
        // q -> 主件
        int[] v = new int[m + 1], p = new int[m + 1], fan = new int[m + 1];
        boolean[] main = new boolean[m + 1];
        int[][] follower = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            v[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
            int q = scanner.nextInt();
            // todo
            p[i] *= v[i];
            main[i] = q == 0;
            if (!main[i]) {
                follower[q][fan[q]++] = i;
            }
        }
        int ans = dfs(n, m + 1, v, p, main, fan, follower, 0, 0);
        System.out.println(ans);
    }

    private static int dfs(int budget, int n, int[] price, int[] value, boolean[] primary, int[] attachmentSize, int[][] attachmentId, int i, int x) {
        if (budget < 0) {
            return 0;
        }
        if (i == n) {
            return budget >= 0 ? x : 0;
        }
        if (!primary[i]) {
            return dfs(budget, n, price, value, primary, attachmentSize, attachmentId, i + 1, x);
        }
        int a = dfs(budget - price[i], n, price, value, primary, attachmentSize, attachmentId, i + 1, x + value[i]);
        if (attachmentSize[i] == 1) {
            int c = dfs(budget - price[i] - price[attachmentId[i][0]], n, price, value, primary, attachmentSize, attachmentId, i + 1, x + value[i] + value[attachmentId[i][0]]);
            a = Integer.max(a, c);
        }
        if (attachmentSize[i] == 2) {
            int c = dfs(budget - price[i] - price[attachmentId[i][0]], n, price, value, primary, attachmentSize, attachmentId, i + 1, x + value[i] + value[attachmentId[i][0]]);
            a = Integer.max(a, c);
            int d = dfs(budget - price[i] - price[attachmentId[i][1]], n, price, value, primary, attachmentSize, attachmentId, i + 1, x + value[i] + value[attachmentId[i][1]]);
            a = Integer.max(a, d);
            int e = dfs(budget - price[i] - price[attachmentId[i][0]] - price[attachmentId[i][1]], n, price, value, primary, attachmentSize, attachmentId, i + 1, x + value[i] + value[attachmentId[i][0]] + value[attachmentId[i][1]]);
            a = Integer.max(a, e);
        }
        int b = dfs(budget, n, price, value, primary, attachmentSize, attachmentId, i + 1, x);
        return Integer.max(a, b);
    }

}
