package io.huhu.leetcode.n1911;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public long maxAlternatingSum(int[] nums) {
        long f = 0, g = 0;
        for (int num : nums) {
            long _f = f;
            f = Math.max(f, g - num);
            g = Math.max(g, _f + num);
        }
        return Math.max(f, g);
    }

}
