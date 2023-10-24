package io.huhu.leetcode.n85;

/**
 * <h1>
 * 85.最大矩形
 * </h1>
 *
 * <p>
 * 给定一个仅包含0合1，大小为rows*cols的二维二进制矩阵，找出只包含1的最大矩形，并返回其面积。
 * </p>
 *
 * <p>
 * rows == matrix.length
 * <br/>
 * cols == matrix[0].length
 * <br/>
 * 1 <= rows, cols <= 200
 * <br/>
 * matrix[i][j] == '0' or '1'
 * </p>
 */
class Solution {

    /**
     * 把矩阵转换为柱状图
     */
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int[] heights = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            int area = largestArea(heights);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    /**
     * 84.柱状图中最大的矩形
     * <br/>
     * 因为矩阵的宽度不会超过200，所以使用暴力求解也是可以的
     */
    private int largestArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) {
                l--;
            }
            int r = i + 1;
            while (r < heights.length && heights[r] >= heights[i]) {
                r++;
            }
            int tmp = (r - l - 1) * heights[i];
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

}
