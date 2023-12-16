package io.huhu.leetcode.back.trace.n2397;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-rows-covered-by-columns/description/">被列覆盖的最多行数</a>
 * <p>给你一个下标从0开始、大小为 m * n 的二进制矩阵 matrix;
 * 另给你一个整数 numSelect, 表示你必须从 matrix 中选择的不同列的数量
 * <p>如果一行中所有的 1 都被你选中的列所覆盖, 则认为这一行被覆盖了
 * <p>形式上, 假设 s = {c1, c2, ..., c<sub>numSelect</sub>} 是你选择的列的集合.
 * 对于矩阵中的某一行 row, 如果满足下述条件, 则认为这一行被集合 s 覆盖:
 * <ul>
 * <li>对于满足 matrix[row][col] == 1 的每个单元格 matrix[row][col] (0 <= col <= n - 1),
 * col均存在于 s 中, 或者
 * <li>row 中不存在值为 1 的单元格
 * </ul>
 * <p>你需要从矩阵中选出 numSelect 个列, 使集合覆盖的行数最大化
 * <p>返回一个整数, 表示可以由 numSelect 列构成的集合覆盖的最大行数
 */
class Solution {

    /**
     * 提示:
     * <ul>
     * <li>m == matrix.length
     * <li>n == matrix[i].length
     * <li>1 <= m, n <= 12
     * <li>matrix[i][j] 要么是 0 要么是 1
     * <li>1 <= numSelect <= n
     * </ul>
     */
    public int maximumRows(int[][] matrix, int numSelect) {
        // 找出所有可能的列的组合
        int n = matrix[0].length;
        List<boolean[]> columns = new ArrayList<>();
        dfs(n, 0, numSelect, 0, new boolean[n], columns);
        // 计算每种组合的覆盖情况
        int m = matrix.length, res = 0;
        for (boolean[] column : columns) {
            int row = 0;
            for (int i = 0; i < m; i++) {
                boolean covered = true;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1 && !column[j]) {
                        covered = false;
                        break;
                    }
                }
                if (covered) {
                    row++;
                }
                res = Math.max(res, row);
            }
        }
        return res;
    }

    /**
     * 深度优先遍历 + 回溯算法
     * <pre>{@code
     * private void dfs(int n, int j, int numSelect, int cnt,
     *         boolean[] path, List<boolean[]> res) {
     *     if (j == n) {
     *         if (cnt == numSelect) {
     *             res.add(path.clone());
     *         }
     *         return;
     *     }
     *     dfs(n, j + 1, numSelect, cnt, path, res);
     *     path[j] = true;
     *     dfs(n, j + 1, numSelect, cnt + 1, path, res);
     *     path[j] = false;
     * }
     * }</pre>
     */
    private void dfs(int n, int j, int numSelect, int cnt, boolean[] path, List<boolean[]> res) {
        if (cnt == numSelect) {
            res.add(path.clone());
            return;
        }
        // 剪枝: 剩余数字不够组合出numSelect
        for (int i = j; i < n && i <= n + cnt - numSelect; i++) {
            path[i] = true;
            dfs(n, i + 1, numSelect, cnt + 1, path, res);
            path[i] = false;
        }
    }

}
