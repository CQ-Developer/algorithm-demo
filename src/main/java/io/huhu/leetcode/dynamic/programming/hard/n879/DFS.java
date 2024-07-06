package io.huhu.leetcode.dynamic.programming.hard.n879;

final class DFS implements Solution {

    @Override
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        return dfs(n, minProfit, group, profit, 0);
    }

    private int dfs(int n, int min, int[] g, int[] p, int i) {
        if (i == g.length || n <= 0) {
            return min <= 0 ? 1 : 0;
        }
        int ans = dfs(n, min, g, p, i + 1);
        if (n >= g[i]) {
            ans += dfs(n - g[i], min - p[i], g, p, i + 1);
        }
        return ans % 1000000007;
    }

}
