package io.huhu.leetcode.dynamic.programming.medium.n53;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">
 * Maximum Subarray
 * </a>
 */
class Solution {

    public int maxSubArray(int[] nums) {
        int ans = nums[0], pre = ans;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Integer.max(ans, pre);
        }
        return ans;
    }

}
