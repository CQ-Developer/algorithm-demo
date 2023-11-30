package io.huhu.leetcode.back.trace.n1219;

/**
 * <a href="https://leetcode.cn/problems/path-with-maximum-gold/description/">1219.黄金矿工</a>
 * <p>你要开发一座金矿, 地址勘探学家已经探明了这座金矿中的资源分布, 并放进大小为m*n的网格grid进行了标注.
 * 每个单元格中的整数就表示这一单元格中的黄金数量; 如果该单元格是空的, 那么就是0.
 * <p>为了使收益最大化, 矿工需要按以下规则来开采黄金:
 * <hl>
 * <li>每当矿工进入一个单元, 就会收集该单元格中的所有黄金.
 * <li>矿工每次可以从当前位置向上下左右四个方向走.
 * <li>每个单元格只能被开采(进入)一次.
 * <li>不得开采(进入)黄金数目为0的单元格.
 * <li>矿工可以从网格中任意一个有黄金的单元格出发或者是停止.
 * </hl>
 */
class Solution {

    /**
     * 1 <= grid.length, grid[i].length <= 15
     * 0 <= gid[i][j] <= 100
     * 最多25个单元格中有黄金
     */
    public int getMaximumGold(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    result = Math.max(result, dfs(grid, i, j));
                }
            }
        }
        return result;
    }

    /**
     * 回溯算法
     * 核心点: 四个方向都进行探索
     */
    private int dfs(int[][] grid, int i, int j) {
        int g = grid[i][j], m = 0;
        grid[i][j] = 0;
        if (i != 0 && grid[i - 1][j] != 0) {
            m = Math.max(m, dfs(grid, i - 1, j));
        }
        if (i != grid.length - 1 && grid[i + 1][j] != 0) {
            m = Math.max(m, dfs(grid, i + 1, j));
        }
        if (j != 0 && grid[i][j - 1] != 0) {
            m = Math.max(m, dfs(grid, i, j - 1));
        }
        if (j != grid[i].length - 1 && grid[i][j + 1] != 0) {
            m = Math.max(m, dfs(grid, i, j + 1));
        }
        grid[i][j] = g;
        return g + m;
    }

}
