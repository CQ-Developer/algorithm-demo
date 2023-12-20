package io.huhu.leetcode.back.trace.lcr.n129;

/**
 * <a href="https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/description/">字母迷宫</a>
 * <p>字母迷宫游戏初始界面记作m*n二维字符串数组grid, 请判断玩家是否能在grid中找出目标单词target
 * <p>注意: 寻找单词时必须按照字母顺序, 通过水平或垂直方向相邻的单元格内的字母构成,
 * 同时, 同一个单元格内的字母不允许被重复使用
 * <p>提示:
 * <li>m == grid.length
 * <li>n == grid[i].length
 * <li>1 <= m, n <= 6
 * <li>1 <= target.length <= 15
 * <li>grid和target仅由大小写英文字母组成
 */
class Solution {

    public boolean wordPuzzle(char[][] grid, String target) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == target.charAt(0) && backTracing(grid, i, j, target, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracing(char[][] grid, int i, int j, String target, int k) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        }
        if (grid[i][j] != target.charAt(k)) {
            return false;
        }
        if (k == target.length() - 1) {
            return true;
        }
        grid[i][j] = '.';
        boolean res = backTracing(grid, i - 1, j, target, k + 1)
                   || backTracing(grid, i + 1, j, target, k + 1)
                   || backTracing(grid, i, j - 1, target, k + 1)
                   || backTracing(grid, i, j + 1, target, k + 1);
        grid[i][j] = target.charAt(k);
        return res;
    }

}
