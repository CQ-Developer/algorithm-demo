package io.huhu.leetcode.dynamic.programming.medium.n300;

class DP implements Solution {

    @Override
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] f = new int[nums.length];
        for (int i = 0; i < f.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = Integer.max(f[i], f[j] + 1);
                }
            }
            ans = Integer.max(ans, f[i]);
        }
        return ans;
    }

}
