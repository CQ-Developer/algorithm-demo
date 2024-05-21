package io.huhu.leetcode.dynamic.programming.medium.n152;

/**
 * <a href="https://leetcode.cn/problems/maximum-product-subarray/description/">乘积最大子数组</a>
 *
 * <p>给你一个整数数组nums, 请你找出数组中乘积最大的非空连续子数组,
 * 并返回该子数组所对应的乘积</p>
 *
 * <p>测试用例的答案是一个32位整数</p>
 *
 * <ul>
 * <li>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></li>
 * <li>-10 &lt;= nums[i] &lt;= 10</li>
 * <li>nums的任何前缀或后缀的乘积都保证是一个32位整数</li>
 * </ul>
 */
class Solution {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, dpMax = 1, dpMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = dpMax;
                dpMax = dpMin;
                dpMin = tmp;
            }
            dpMax = Math.max(dpMax * num, num);
            dpMin = Math.min(dpMin * num, num);
            max = Math.max(max, dpMax);
        }
        return max;
    }

}
