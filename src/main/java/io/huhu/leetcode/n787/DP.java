package io.huhu.leetcode.n787;

import java.util.Arrays;

class DP implements Code {

    private static final int INF = 49500000;

    @Override
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ans = INF;
        int[] pre = new int[n], cur = new int[n];
        Arrays.fill(pre, INF);
        pre[src] = 0;
        for (int i = 1; i <= k + 1; i++) {
            Arrays.fill(cur, INF);
            for (int[] flight : flights) {
                int f = flight[0], t = flight[1], p = flight[2];
                cur[t] = Math.min(cur[t], pre[f] + p);
            }
            for (int j = 0; j < n; j++) {
                pre[j] = cur[j];
            }
            ans = Math.min(ans, pre[dst]);
        }
        return ans == INF ? -1 : ans;
    }

}
