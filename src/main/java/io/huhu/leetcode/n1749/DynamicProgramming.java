package io.huhu.leetcode.n1749;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    /**
     * 分别求子数组的最大和和最小和
     */
    @Override
    public int maxAbsoluteSum(int[] nums) {
        int mx = 0, mn = 0, ans = 0;
        for (int num : nums) {
            mx = Math.max(0, mx) + num;
            mn = Math.min(0, mn) + num;
            ans = Math.max(ans, Math.max(mx, -mn));
        }
        return ans;
    }

}
