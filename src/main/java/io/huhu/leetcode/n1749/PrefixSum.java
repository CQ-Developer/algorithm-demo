package io.huhu.leetcode.n1749;

import io.huhu.AC;

@AC
class PrefixSum implements Code {

    /**
     * maxPre - minPre = maxResult
     */
    @Override
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0, mx = 0, mn = 0;
        for (int num : nums) {
            sum += num;
            if (sum > mx) {
                mx = sum;
            }
            if (sum < mn) {
                mn = sum;
            }
        }
        return mx - mn;
    }

}
