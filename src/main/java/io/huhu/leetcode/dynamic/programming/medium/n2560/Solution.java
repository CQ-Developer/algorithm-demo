package io.huhu.leetcode.dynamic.programming.medium.n2560;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iv/description/">
 * House Robber IV
 * </a>
 */
class Solution {

    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int num : nums) {
            l = Integer.min(l, num);
            r = Integer.max(r, num);
        }
        while (l <= r) {
            int m = (l + r) >> 1, c = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= m) {
                    if (++c >= k) {
                        break;
                    }
                    i++;
                }
            }
            if (c >= k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
