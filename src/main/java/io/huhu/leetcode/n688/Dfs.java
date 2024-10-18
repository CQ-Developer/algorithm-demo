package io.huhu.leetcode.n688;

public class Dfs implements Code {

    @Override
    public double knightProbability(int n, int k, int row, int column) {
        return f(n, k, row, column);
    }

    public double f(int n, int k, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        double ans = 0;
        ans += f(n, k - 1, i + 1, j + 2) / 8;
        ans += f(n, k - 1, i + 1, j - 2) / 8;
        ans += f(n, k - 1, i - 1, j + 2) / 8;
        ans += f(n, k - 1, i - 1, j - 2) / 8;
        ans += f(n, k - 1, i + 2, j + 1) / 8;
        ans += f(n, k - 1, i + 2, j - 1) / 8;
        ans += f(n, k - 1, i - 2, j + 1) / 8;
        ans += f(n, k - 1, i - 2, j - 1) / 8;
        return ans;
    }

}
