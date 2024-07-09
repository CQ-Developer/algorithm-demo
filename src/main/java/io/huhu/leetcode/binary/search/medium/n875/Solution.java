package io.huhu.leetcode.binary.search.medium.n875;

/**
 * <a href="https://leetcode.cn/problems/koko-eating-bananas/description/">
 * KoKo Eating Bananas
 * </a>
 */
class Solution {

    /**
     * <li>
     * 1 <= piles.length <= 10<sup>4</sup>
     * </li>
     * <li>
     * piles.length <= h <= 10<sup>9</sup>
     * </li>
     * <li>
     * 1 <= piles[i] <= 10<sup>9</sup>
     * </li>
     */
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int p : piles) {
            if (p > r) {
                r = p;
            }
        }
        int ans = 0;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (can(piles, m) <= h) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private long can(int[] piles, int m) {
        long ans = 0;
        for (int p : piles) {
            ans += (p + m - 1) / m;
        }
        return ans;
    }

}
