package io.huhu.leetcode.n84;

import java.util.Stack;

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
 *
 * <p>
 * 提示：
 * <br/>
 * 1 <= heights.length <= 10<sup>5</sup>
 * <br/>
 * 0 <= heights[i] <= 10<sup>4</sup>
 * </p>
 */
class Solution {

    /**
     * 暴力求解会起始简单移动，但是会超时，实际上在数组长度不大的情况下，用暴力求解非常合适，代码简单优雅：
     * <br/>
     * <pre>{@code
     * public int largestRectangleArea(int[] heights) {
     *     int max = 0;
     *     for (int i = 0; i < heights.length; i++) {
     *         int l = i - 1;
     *         while (l >= 0 && heights[l] >= heights[i]) {
     *             l--;
     *         }
     *         int r = i + 1;
     *         while (r < heights.length && heights[r] >= heights[i]) {
     *             r++;
     *         }
     *         int tmp = (r - l - 1) * heights[i];
     *         if (tmp > max) {
     *             max = tmp;
     *         }
     *     }
     *     return max;
     * }
     * }</pre>
     * 使用单调递增栈进行时间复杂度优化
     * <br/>
     * 1.核心思想：求每根柱子可以向左右延申的长度(矩形的最大宽度)、高(柱子的高度)，计算以每根柱子高度为高的矩形面积，维护面积的最大值
     * <br/>
     * 2.朴素想法：遍历每一根柱子的高度然后向两边进行扩散到最大宽度
     * <br/>
     * 3.单调栈优化：因为最终的目的是寻找对应柱子的height[i]右边首个小于height[i]的柱子height[r]，左边同理找到首个小于height[i]的柱子height[l]，
     * 维护一个单调递增栈，那么每当遇到新加入的元素小于栈顶，便可以确定栈顶柱子右边界，而栈顶柱子左边界就是栈顶柱子下面的柱子，
     * 左右边界确定以后就可以进行面积计算与维护最大面积
     * <br/>
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length + 1 - 1);
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int area = newHeights[stack.pop()] * (i - 1 - stack.peek());
                if (area > max) {
                    max = area;
                }
            }
            stack.push(i);
        }
        return max;
    }

}
