package io.huhu.leetcode.dynamic.programming.core.house.robber.n2560;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iv/description/">打家劫舍IV</a>
 */
class Solution {

    public int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            right = Math.max(right, num);
        }
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mid) {
        int p = 0, c = 0;
        for (int num : nums) {
            if (num > mid) {
                p = c;
            } else {
                int t = c;
                c = Math.max(c, p + 1);
                p = t;
            }
        }
        return c >= k;
    }

}
