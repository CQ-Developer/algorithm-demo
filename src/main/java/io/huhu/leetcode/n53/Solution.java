package io.huhu.leetcode.n53;

/**
 * <h1>53.最大子数组和</h1>
 * <p>给你一个整数数组nums，请你找出一个具有最大和的连续子数组(子数组最少包含一个元素)，返回其最大和。<br>
 * 子数组是数组中的一个连续部分。</p>
 * <p>示例1：<br>
 * 输入：nums=[-2,1,-3,4,-1,2,1,-5,4]<br>
 * 输出：6<br>
 * 解释：连续子数组[4,-1,2,1]的和最大，为6。</p>
 * <p>示例2：<br>
 * 输入：nums=[1]<br>
 * 输出：1</p>
 * <p>示例3：<br>
 * 输入：nums=[5,4,-1,7,8]<br>
 * 输出：23</p>
 * <p>提示：<br>
 * 1 <= nums.length <= 10<sup>5</sup><br>
 * -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup></p>
 * <p>进阶：<br>
 * 如果你已经实现了复杂度为O(n)的解法，尝试使用更为精妙的分治法求解。</p>
 */
class Solution {

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int num : nums) {
            pre = num > num + pre ? num : num + pre;
            max = max > pre ? max : pre;
        }
        return max;
    }

}
