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
        int ans = dfs(n, m, v, p, main, fan, follower);
        System.out.println(ans);
    }

    private static int dfs(int n, int m, int[] v, int[] p, boolean[] main, int[] fan, int[][] follower) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
