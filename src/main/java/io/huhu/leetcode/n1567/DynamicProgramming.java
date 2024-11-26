package io.huhu.leetcode.n1567;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int getMaxLen(int[] nums) {
        int p = nums[0] > 0 ? 1 : 0;
        int n = nums[0] < 0 ? 1 : 0;
        int ans = p;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                p++;
                n = n == 0 ? 0 : n + 1;
            } else if (nums[i] < 0) {
                int _n = n;
                n = p + 1;
                p = _n == 0 ? 0 : _n + 1;
            } else {
                p = n = 0;
            }
            ans = Math.max(ans, p);
        }
        return ans;
    }

}
