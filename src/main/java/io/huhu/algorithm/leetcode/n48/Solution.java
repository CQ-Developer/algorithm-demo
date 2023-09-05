package io.huhu.algorithm.leetcode.n48;

/**
 * <h1>
 * 48.旋转图像
 * </h1>
 * <p>
 * 给定义个n*n的二维矩阵matrix，表示一个图像。请你将图像顺时针旋转90度。
 * <br>
 * 你必须在原地旋转图像，这意味着你需要要直接修改输入的二维矩阵。
 * <br>
 * 请不要使用另一个矩阵来旋转图像。
 * </p>
 * <br>
 *
 * <p>
 * <b>示例1：</b>
 * <br>
 * <img src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg">
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <br>
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * </p>
 * <br>
 *
 * <p>
 * <b>示例2：</b>
 * <br>
 * <img src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg">
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * <br>
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * </p>
 * <br>
 *
 * <p>
 * <b>提示：</b>
 * <br>
 * n == matrix.length == matrix[i].length
 * <br>
 * i <= n <= 20
 * <br>
 * -1000 <= matrix[i][j] <= 1000
 * </p>
 */
class Solution {

    /**
     * <h2>
     * 原地旋转
     * </h2>
     * <p>
     * <b>关键点1：</b>旋转的规则？
     * <br>
     * <b>关键点2：</b>需要旋转几轮？
     * </p>
     *
     * @param matrix 矩阵
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = t;
            }
        }
    }

}
