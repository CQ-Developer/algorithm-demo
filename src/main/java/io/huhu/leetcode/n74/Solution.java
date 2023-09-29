package io.huhu.leetcode.n74;

/**
 * <h1>
 * 74.搜索二维矩阵
 * </h1>
 *
 * <p>
 * 给你一个满足下述两条属性的m*n整数矩阵：
 * <br/>
 * 每行中的整数从左到右按非递减顺序排列。
 * <br/>
 * 每行的第一个整数大于前一行的最后一个整数。
 * </p>
 *
 * <p>
 * 给你一个整数target，如果target在矩阵中，返回true；否则返回false。
 * </p>
 *
 * <p>
 * 示例一：
 * <br/>
 * <img src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg"/>
 * <br/>
 * 输入：matrix=[[1,3,5,7],[10,11,16,20],[23,30,34,60]], target=3
 * <br/>
 * 输出：true
 * </p>
 *
 * <p>
 * 示例二：
 * <br/>
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/mat2.jpg"/>
 * <br/>
 * 输入：matrix=[[1,3,5,7],[10,11,16,20],[23,30,34,60]]，target=13
 * <br/>
 * 输出：false
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * m == matrix.length
 * <br/>
 * n = matrix[i].length
 * <br/>
 * 1 <= m, n <= 100
 * <br/>
 * -10<sup>4</sup> <= matrix[i][j], target <= 10<sup>4</sup>
 * </p>
 */
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 若target小于第一行的一个元素，或小于最后一行的最后一个元素
        // 那么target一定不在矩阵内
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            // 若当前行的首个元素大于target无需再继续遍历
            if (matrix[i][0] > target) {
                break;
            }
            // target在当前行范围内
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
                // 后续行的元素一定大于当前行的所有元素，无需再遍历
                return false;
            }
        }
        return false;
    }

}
