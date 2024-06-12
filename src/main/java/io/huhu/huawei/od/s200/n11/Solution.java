package io.huhu.huawei.od.s200.n11;

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
        int m = scanner.nextInt(), n = scanner.nextInt(), s = 0;
        int[][] start = new int[2][];
        int[][] gridA = new int[m][n];
        int[][] gridB = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                gridA[i][j] = gridB[i][j] = num;
                if (num == 2) {
                    start[s++] = new int[]{i, j};
                }
            }
        }
        // alg
        int[][] table = new int[m][n];
        dfs(gridA, start[0][0], start[0][1], table);
        dfs(gridB, start[1][0], start[1][1], table);
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

    private static void dfs(int[][] grid, int i, int j, int[][] table) {
        if (grid[i][j] == 3) {
            table[i][j]++;
        }
        grid[i][j] = 1;
        if (i > 0 && grid[i - 1][j] != 1) {
            dfs(grid, i - 1, j, table);
        }
        if (i + 1 < grid.length && grid[i + 1][j] != 1) {
            dfs(grid, i + 1, j, table);
        }
        if (j > 0 && grid[i][j - 1] != 1) {
            dfs(grid, i, j - 1, table);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] != 1) {
            dfs(grid, i, j + 1, table);
        }
    }

}
