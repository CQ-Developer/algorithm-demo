package io.huhu.leetcode.n1493;

import io.huhu.AC;

@AC
class SlidingWindow implements Code {

    /**
     * find a window that only contains one zero
     */
    @Override
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int l = 0, r = 0, x = -1;
        for (; r < nums.length; r++) {
            if (nums[r] == 0) {
                if (x >= l) {
                    ans = Math.max(ans, r - l - 1);
                    l = x + 1;
                }
                x = r;
            }
        }
        return Math.max(ans, r - l - 1);
    }

}
