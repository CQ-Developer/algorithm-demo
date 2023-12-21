package io.huhu.leetcode.back.trace.interview.questions.n08.n02;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/robot-in-a-grid-lcci/description/">迷路的机器人</a>
 * <p>设想有个机器人坐在一个网格的左上角, 网格r行c列.
 * 机器人只能向下或向右移动, 但不能走到一些被禁止的网格(有障碍物).
 * 设计一种算法, 寻找机器人从左上角移动到右下角的路径.
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png"/>
 * <p>网格中的障碍物和空位置分别用1和0来表示.
 * <p>返回一条可行的路径, 路径由经过的网格行号和列好组成.
 * 左上角为0行0列. 如果没有可行的路径, 返回空数组.
 * <p>说明: r和c的值均不超过100.
 */
class Solution {

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        int r = obstacleGrid.length;
        if (r == 0) {
            return res;
        }
        int c = obstacleGrid[0].length;
        if (obstacleGrid[r - 1][c - 1] == 1) {
            return res;
        }
        backTracing(obstacleGrid, r, c, 0, 0, new boolean[r][c], res);
        return res;
    }

    private boolean backTracing(int[][] obstacleGrid, int r, int c, int i, int j, boolean[][] used, List<List<Integer>> res) {
        if (i >= r || j >= c || obstacleGrid[i][j] == 1 || used[i][j]) {
            return false;
        }
        res.add(List.of(i, j));
        used[i][j] = true;
        if (i == r - 1 && j == c - 1) {
            return true;
        }
        if (backTracing(obstacleGrid, r, c, i, j + 1, used, res) || backTracing(obstacleGrid, r, c, i + 1, j, used, res)) {
            return true;
        }
        res.remove(res.size() - 1);
        return false;
    }

}
