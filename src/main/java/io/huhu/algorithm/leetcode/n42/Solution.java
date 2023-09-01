package io.huhu.algorithm.leetcode.n42;

/**
 * <h1>接雨水</h1>
 * <p>给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的主子，下雨之后能接多少雨水</p>
 * <br>
 *
 * <h2>测试条件</h2>
 * <ul>
 *     <li>n == height.length</li>
 *     <li>1 <= n <= 2 * 10<sup>4</sup></li>
 *     <li>0 <= height[i] <= 10<sup>5</sup></li>
 * </ul>
 * <br>
 *
 * <h3>示例一：</h3>
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png"/>
 * <p>输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]</p>
 * <p>输出：6</p>
 */
class Solution {

    /**
     * <h2>解法一：按列求量</h2>
     * <p>思想核心：计算每一列能接住的水滴</p>
     * <ol>
     *     <li><若要计算当前列能接住的水量，则要找出当前列左右两边最高的列，并根据木桶效应，是否能接住水取决于左右两端较矮的列。/li>
     *     <li>并且当前列能否接住水的唯一条件是，当前列小于两端较矮的那一列。</li>
     *     <li>能接住多少水就等于两端较矮的列和当前列的差值。</li>
     * </ol>
     *
     * @param height 表示柱子高度的数组
     * @return 接住的雨水数量
     */
    public int trap1(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // 找左边最高的列
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            // 找到右边最高的列
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] > maxRight) {
                    maxRight = height[j];
                }
            }
            // 找到最低列
            int min = Math.min(maxLeft, maxRight);
            // 计算水量
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * <h2>解法二：动态规划</h2>
     * <p>核心思想：提前找出i位置的左侧最大值和右侧最大值</p>
     *
     * @param height 表示柱子高度的数组
     * @return 接住的雨水数量
     */
    public int trap2(int[] height) {
        int sum = 0;
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        // 记录i左侧最大值
        for (int i = 1; i < height.length - 1; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i - 1]);
        }
        // 记录i右侧最大值
        for (int i = height.length - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i + 1]);
        }
        // 计算雨量
        for (int i = 1; i < height.length; i++) {
            int min = Math.min(maxL[i], maxR[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

}
