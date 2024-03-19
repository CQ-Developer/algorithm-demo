package io.huhu.leetcode.dynamic.programming.easy.interview.n16.n17;

/**
 * <a href="https://leetcode.cn/problems/contiguous-sequence-lcci/description/">连续数列</a>
 */
class Solution {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

}
