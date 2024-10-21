package io.huhu.leetcode.n787;

import java.util.Arrays;

class DFS implements Code {

    private static final int INF = 49500000;

    @Override
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] m = new int[n][k + 2];
        for (int[] a : m) {
            Arrays.fill(a, -1);
        }
        int ans = f(flights, src, dst, k + 1, m);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int f(int[][] flights, int i, int j, int k, int[][] m) {
        if (k < 0) {
            return INF;
        }
        if (i == j) {
            return 0;
        }
        if (m[i][k] != -1) {
            return m[i][k];
        }
        int ans = INF;
        for (int[] flight : flights) {
            if (flight[0] == i) {
                ans = Math.min(ans, f(flights, flight[1], j, k - 1, m) + flight[2]);
            }
        }
        return m[i][k] = ans;
    }

}
