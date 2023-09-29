package io.huhu.leetcode.n73;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>
 * 73.矩阵置零
 * </h1>
 *
 * <p>
 * 给定一个m*n的矩阵，如果一个元素为0，则将其所在行和列的所有元素都设为0。请使用原地算法。
 * </p>
 *
 * <p>
 * 示例1：
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg"/>
 * <br/>
 * 输入：matrix=[[1,1,1],[1,0,1],[1,1,1]]
 * <br/>
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * </p>
 *
 * <p>
 * 示例2：
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg"/>
 * <br/>
 * 输入：matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * <br/>
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * m == matrix.length
 * <br/>
 * n == matrix[0].length
 * <br/>
 * 1 <=m, n <= 200
 * <br/>
 * -2<sup>31</sup> <= matrix[i][j] <= 2<sup>31</sup> - 1
 * </p>
 *
 * <p>
 * 进阶：
 * <br/>
 * 一个直观的解决方案是使用O(mn)的额外空间，但这并不是一个好的解决方案。
 * <br/>
 * 一个简单的改进方案是使用O(m+n)的额外空间，但这仍然不是最好的解决方案。
 * <br/>
 * 你能想出一个使用常量空间的解决方案吗？
 * </p>
 */
class Solution {

    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        // 记录零所在的行和列
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        // 将行置零
        for (int i : row) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        // 将列置零
        for (int i = 0; i < m; i++) {
            for (int j : col) {
                matrix[i][j] = 0;
            }
        }
    }

}
