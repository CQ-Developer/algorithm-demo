package io.huhu.leetcode.dynamic.programming.medium.n396;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/rotate-function/description/">Rotate Function</a>
 * </h1>
 * <p>You are given an integer array nums of length n.</p>
 * <p>Assume arr<sub>k</sub> to be an array obtained by rotating nums by k positions clock-wise.
 * We define rotation function F on nums as follow:</p>
 * <ul>
 * <li>F(k) = 0 * arr<sub>k</sub>[0] + 1 * arr<sub>k</sub>[1] + ... + (n - 1) * arr<sub>k</sub>[n - 1]</li>
 * </ul>
 * <p>Return the maximum value of F(0), F(1), ..., F(n - 1).</p>
 * <p>The test cases are generated so that the answer fits in a 32-bit integer.</p>
 */
class Solution {

    /**
     * <ul>
     * <li>n == nums.length</li>
     * <li>1 &lt;= n &lt;= 10<sup>5</sup></li>
     * <li>-100 &lt;= nums[i] &lt;= 100</li>
     * </ul>
     */
    public int maxRotateFunction(int[] nums) {
        int n = nums.length, result = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++) {
            int i = (n - k) % n, j = (i + 1) % n;
            int num = 0, f = 1;
            while (j != i) {
                num += (f++ * nums[j]);
                j = (j + 1) % n;
            }
            if (result < num) {
                result = num;
            }
        }
        return result;
    }

}
