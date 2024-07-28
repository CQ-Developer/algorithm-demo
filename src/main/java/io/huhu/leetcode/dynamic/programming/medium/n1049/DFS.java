package io.huhu.leetcode.dynamic.programming.medium.n1049;

class DFS implements Solution {

    @Override
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = stones.length, m = (sum >> 1) + 1;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                f[i][j] = -1;
            }
        }
        int required = dfs(stones, 0, sum >> 1, 0, f);
        return sum - required - required;
    }

    private int dfs(int[] stones, int i, int t, int j, int[][] f) {
        if (i == stones.length) {
            return j;
        }
        if (f[i][j] != -1) {
            return f[i][j];
        }
        f[i][j] = dfs(stones, i + 1, t, j, f);
        if (j + stones[i] <= t) {
            f[i][j] = Integer.max(f[i][j], dfs(stones, i + 1, t, j + stones[i], f));
        }
        return f[i][j];
    }

}
