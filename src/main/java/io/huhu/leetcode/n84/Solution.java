package io.huhu.leetcode.n84;

/**
 * <h1>
 * 84.柱状图中最大的矩形
 * </h1>
 *
 * <p>
 * 给定n个非负整数，用来表示柱状图中各个柱子的高度。
 * <br/>
 * 每个柱子彼此相邻，且宽度为1。
 * <br/>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * </p>
 */
class Solution {

    /**
     * <h2>
     * 提示：
     * </h2>
     *
     * <p>
     * 1 <= heights.length <= 10<sup>5</sup>
     * </p>
     *
     * <p>
     * 0 <= heights[i] <= 10<sup>4</sup>
     * </p>
     */
    public int largestRectangleArea(int[] heights) {
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
