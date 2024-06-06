package io.huhu.leetcode.classic.house.robber.n2560;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iv/description/">打家劫舍IV</a>
 */
class Solution {

    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > r) {
                r = num;
            }
            if (num < l) {
                l = num;
            }
        }
        while (l <= r) {
            int m = l + r >> 1, c = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= m) {
                    if (++c == k) {
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
