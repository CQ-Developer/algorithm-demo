package io.huhu.leetcode.n120;

import java.util.List;

class DFS implements Code {

    @Override
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(m - 1).size();
        return f(triangle, 0, 0, new Integer[m][n]);
    }

    private int f(List<List<Integer>> triangle, int i, int j, Integer[][] dp) {
        if (i == triangle.size()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        return dp[i][j] = triangle.get(i).get(j) + Math.min(f(triangle, i + 1, j, dp), f(triangle, i + 1, j + 1, dp));
    }

}
