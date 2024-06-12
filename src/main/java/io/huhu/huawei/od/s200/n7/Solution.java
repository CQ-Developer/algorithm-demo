package io.huhu.huawei.od.s200.n7;

import java.util.Scanner;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135119154">可以组成网络的服务器</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int res = countMaxNumOfServers(grid, n, m);
        System.out.println(res);
    }

    public static int countMaxNumOfServers(int[][] grid, int n, int m) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j, n, m));
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] grid, int i, int j, int n, int m) {
        int ans = grid[i][j];
        grid[i][j] = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            ans += dfs(grid, i - 1, j, n, m);
        }
        if (i + 1 < n && grid[i + 1][j] == 1) {
            ans += dfs(grid, i + 1, j, n, m);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            ans += dfs(grid, i, j - 1, n, m);
        }
        if (j + 1 < m && grid[i][j + 1] == 1) {
            ans += dfs(grid, i, j + 1, n, m);
        }
        return ans;
    }

}
