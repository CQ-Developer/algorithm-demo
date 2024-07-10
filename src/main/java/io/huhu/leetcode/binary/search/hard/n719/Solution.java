package io.huhu.leetcode.binary.search.hard.n719;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-k-th-smallest-pair-distance/description/">
 * Find K-th Smallest Pair Distance
 * </a>
 */
class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        int ans = 0;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (f(nums, m) >= k) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private int f(int[] nums, int m) {
        int ans = 0;
        for (int l = 0, r = 0; l < nums.length; l++) {
            while (r + 1 < nums.length && nums[r + 1] <= nums[l] + m) {
                r++;
            }
            ans += r - l;
        }
        return ans;
    }

}
