package io.huhu.leetcode.n63;

/**
 * <h1>
 * 63.不同路径II
 * </h1>
 * <p>
 * 一个机器人位于一个m*n网格的左上角(起始点在图中标记为"Start")。
 * <br/>
 * 机器种每次只能向下或向右移动一步。机器人试图达到网格的右下角(在下图中标记为"Finish")。
 * <br/>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <br/>
 * 网格中的障碍物和空位置分别用1和0来表示。
 * </p>
 * <p>
 * 示例1：
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg"/>
 * <br/>
 * 输入：obstacleGrid=[[0,0,0],[0,1,0],[0,0,0]]
 * <br/>
 * 输出：2
 * <br/>
 * 解释：3*3网格的正中间有一个障碍物。
 * <br/>
 * 从左上角到右下角一共有2条不同的路径：
 * <br/>
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * <br/>
 * 2. 向下 -> 向下 -> 向右 -> 向有
 * </p>
 * <p>
 * 示例2：
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2020/11/04/robot2.jpg"/>
 * <br/>
 * 输入：obstacleGrid=[[0,1],[0,0]]
 * <br/>
 * 输出：1
 * </p>
 * <br/>
 * <hr/>
 * <p>提示：</p>
 * <ul>
 * <li><b>m == obstacleGrid.length</b></li>
 * <li><b>n == obstacleGrid[i].length</b></li>
 * <li><b>1 <= m, n <= 100</b></li>
 * <li><b>obstacleGrid[i][j] == 0 or 1</b></li>
 * </ul>
 */
class Solution {

    /**
     * 动态规划，参考62题
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 如果终点上有障碍物，那么永远不可能抵达终点
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        // 初始化第1列，遇到障碍物停止
        // 因为只能向下走，所以第1列障碍物下方不可达
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            obstacleGrid[i][0] = -1;
        }
        // 初始化第1行，遇到障碍物停止
        // 因为只能向右走，所以第1行障碍物右侧不可达
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            obstacleGrid[0][i] = -1;
        }
        // 如果当前位置就是障碍物，那么不需要处理
        // 如果左侧是障碍物，那么不可能从左侧向右走到当前位置
        // 如果上方是障碍物，那么不可能从上方向下走到当前位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    int left = obstacleGrid[i][j - 1] == 1 ? 0 : obstacleGrid[i][j - 1];
                    int up = obstacleGrid[i - 1][j] == 1 ? 0 : obstacleGrid[i - 1][j];
                    obstacleGrid[i][j] = left + up;
                }
            }
        }
        return -obstacleGrid[m - 1][n - 1];
    }

}
