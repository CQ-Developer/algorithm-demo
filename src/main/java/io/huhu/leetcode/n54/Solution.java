package io.huhu.leetcode.n54;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>54.螺旋矩阵</h1>
 * <p>给你一个m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。</p>
 * <p>示例1：<br>
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg"><br>
 * 输入：matrix=[[1,2,3],[4,5,6],[7,8,9]]<br>
 * 输出：[1,2,3,6,9,8,7,4,5]</p>
 * <p>示例2：<br>
 * <img src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg"><br>
 * 输入：[[1,2,3,4],[5,6,7,8],[9,10,11,12]]<br>
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]</p>
 * <p>提示：<br>
 * <b>m == matrix.length</b><br>
 * <b>n == matrix[i].length</b><br>
 * <b>1 <= m, n <= 10</b><br>
 * <b>-100 <= matrix[i][j] <= 100</b></p>
 */
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return List.of();
        }
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        while (true) {
            // 从左向右
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            // 下次从右向左只能打印下移一行
            if (++t > b) {
                break;
            }
            // 从上向下
            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            // 下次从上向下需要左移一列
            if (--r < l) {
                break;
            }
            // 从右向左
            for (int i = r; i >= l; i--) {
                result.add(matrix[b][i]);
            }
            // 下次从右向左需要上移一列
            if (--b < t) {
                break;
            }
            // 从下向上
            for (int i = b; i >= t; i--) {
                result.add(matrix[i][l]);
            }
            // 下次从下向上需要右移一列
            if (++l > r) {
                break;
            }
        }
        return result;
    }

}
