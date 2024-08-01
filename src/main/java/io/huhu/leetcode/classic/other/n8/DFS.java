package io.huhu.leetcode.classic.other.n8;

import java.util.Scanner;

/**
 * <a href="https://www.luogu.com.cn/problem/P1616">疯狂的采药</a>
 */
class DFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt(), n = sc.nextInt();
        int[] t = new int[n], v = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        long[][] f = new long[n][time + 1];
        long ans = dfs(time, n, t, v, 0, f);
        System.out.println(ans);
    }

    private static long dfs(int time, int n, int[] t, int[] v, int i, long[][] f) {
        if (i == n) {
            return 0;
        }
        if (f[i][time] != 0) {
            return f[i][time];
        }
        f[i][time] = dfs(time, n, t, v, i + 1, f);
        if (time - t[i] >= 0) {
            f[i][time] = Long.max(f[i][time], dfs(time - t[i], n, t, v, i, f) + (long) v[i]);
        }
        return f[i][time];
    }

}
