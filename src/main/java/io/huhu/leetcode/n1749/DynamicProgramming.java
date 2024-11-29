package io.huhu.leetcode.n1749;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    /**
     * 分别求子数组的最大和和最小和
     */
    @Override
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length, ans = 0;
        int[] maxF = new int[n + 1], minF = new int[n + 1];
        for (int i = 0; i < n; i++) {
            maxF[i + 1] = Math.max(0, maxF[i]) + nums[i];
            minF[i + 1] = Math.min(0, minF[i]) + nums[i];
            ans = Math.max(ans, Math.max(maxF[i + 1], -minF[i + 1]));
        }
        return ans;
    }

}
