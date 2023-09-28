package io.huhu.leetcode.n64;

/**
 * <h1>
 * 64.最小路径和
 * </h1>
 *
 * <p>
 * 给定一个包含非负整数的m*n网格grid，请找出一条从左上角到右下角的路径，是的路径上的数字总和为最小。
 * <br/>
 * 说明：每次只能向下或者向右移动一步。
 * </p>
 *
 * <p>
 * 示例1：
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg"/>
 * <br/>
 * 输入：grid=[[1,3,1],[1,5,1],[4,2,1]]
 * <br/>
 * 输出：7
 * <br/>
 * 解释：因为路径1->3->1->1->1的总和最小
 * </p>
 *
 * <p>
 * 示例2：
 * <br/>
 * 输入：grid=[[1,2,3],[4,5,6]]
 * <br/>
 * 输出：12
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * m == grid.length
 * <br/>
 * n == grid[i].length
 * <br/>
 * 1 <= m, n <= 200
 * <br/>
 * 0 <= grid[i][j] <= 200
 * </p>
 */
class Solution {

    /** 动态规划，参考第62，63题 */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) {
                    if (i == 0) {
                        grid[i][j] = grid[i][j] + grid[i][j - 1];
                    } else if (j == 0) {
                        grid[i][j] = grid[i][j] + grid[i - 1][j];
                    } else {
                        int min = Math.min(grid[i][j - 1], grid[i - 1][j]);
                        grid[i][j] = grid[i][j] + min;
                    }
                }
            }
        }
        return grid[m - 1][n - 1];
    }

}
