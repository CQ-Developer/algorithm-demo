package io.huhu.huawei.od.s200.n11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    /**
     * 4 4
     * 2 1 0 3
     * 0 1 2 1
     * 0 3 0 0
     * 0 0 0 0
     * -> 2
     *
     * 4 4
     * 2 1 2 3
     * 0 1 0 0
     * 0 1 0 0
     * 0 1 0 0
     * -> 0
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input
        int m = scanner.nextInt(), n = scanner.nextInt();
        List<int[]> start = new ArrayList<>();
        int[][] gridA = new int[m][n];
        int[][] gridB = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                gridA[i][j] = gridB[i][j] = num;
                if (num == 2) {
                    start.add(new int[]{i, j});
                }
            }
        }
        // alg
        int[][] table = new int[m][n];
        dfs(gridA, m, n, start.get(0)[0], start.get(0)[1], table);
        dfs(gridB, m, n, start.get(1)[0], start.get(1)[1], table);
        // output
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (table[i][j] == 2) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static void dfs(int[][] grid, int m, int n, int i, int j, int[][] table) {
        if (grid[i][j] == 3) {
            table[i][j]++;
        }
        grid[i][j] = 1;
        if (i > 0 && grid[i - 1][j] != 1) {
            dfs(grid, m, n, i - 1, j, table);
        }
        if (i + 1 < m && grid[i + 1][j] != 1) {
            dfs(grid, m, n, i + 1, j, table);
        }
        if (j > 0 && grid[i][j - 1] != 1) {
            dfs(grid, m, n, i, j - 1, table);
        }
        if (j + 1 < n && grid[i][j + 1] != 1) {
            dfs(grid, m, n, i, j + 1, table);
        }
    }

}
