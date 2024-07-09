package io.huhu.leetcode.binary.search.hard.n410;

/**
 * <a href="https://leetcode.cn/problems/split-array-largest-sum/description/">
 * Split Array Largest Sum
 * </a>
 */
class Solution {

    public int splitArray(int[] nums, int k) {
        long l = Integer.MAX_VALUE, r = 0;
        for (int n : nums) {
            r += n;
            l = Long.min(l, n);
        }
        long ans = 0;
        while (l <= r) {
            long m = l + ((r - l) >> 1);
            if (spilt(nums, m) <= k) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int) ans;
    }

    private int spilt(int[] nums, long m) {
        int c = 0, ans = 1;
        for (int n : nums) {
            if (n > m) {
                return Integer.MAX_VALUE;
            }
            if (c + n <= m) {
                c += n;
            } else {
                c = n;
                ans++;
            }
        }
        return ans;
    }

}
