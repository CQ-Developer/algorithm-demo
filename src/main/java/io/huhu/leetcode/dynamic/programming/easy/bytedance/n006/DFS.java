package io.huhu.leetcode.dynamic.programming.easy.bytedance.n006;

class DFS implements Solution {

    @Override
    public int buy(int n, int x, int[] price, int[] discount, int[] happy) {
        int m = 0, k = 0;
        for (int i = 0; i < n; i++) {
            price[i] -= discount[i];
            m += price[i];
            k += discount[i];
        }
        int[][][] f = new int[n][m + 1][k + 1];
        return dfs(n, x, price, discount, happy, f, 0, 0, 0, 0);
    }

    private int dfs(int n, int x, int[] price, int[] discount, int[] happy, int[][][] f, int i, int j, int k, int sum) {
        if (i == n) {
            return j >= k - x ? sum : 0;
        }
        if (f[i][j][k] != 0) {
            return f[i][j][k];
        }
        int a = dfs(n, x, price, discount, happy, f, i + 1, j, k, sum);
        int b = dfs(n, x, price, discount, happy, f, i + 1, j + price[i], k + discount[i], sum + happy[i]);
        return f[i][j][k] = Integer.max(a, b);
    }

}
