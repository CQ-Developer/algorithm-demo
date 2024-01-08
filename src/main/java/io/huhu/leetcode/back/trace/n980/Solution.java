package io.huhu.leetcode.back.trace.n980;

/**
 * <a href="https://leetcode.cn/problems/unique-paths-iii/description/">不同路径III</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= grid.length * grid[i].length <= 20</li>
     * </ul>
     */
    public int uniquePathsIII(int[][] grid) {
        int x = 0, y = 0, cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
                if (grid[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return dfs(grid, x, y, cnt);
    }

    private int dfs(int[][] grid, int i, int j, int cnt) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return cnt == -1 ? 1 : 0;
        }
        grid[i][j] = -1;
        int res = dfs(grid, i - 1, j, cnt - 1) + dfs(grid, i + 1, j, cnt - 1) + dfs(grid, i, j - 1, cnt - 1) + dfs(grid, i, j + 1, cnt - 1);
        grid[i][j] = 0;
        return res;
    }

}
