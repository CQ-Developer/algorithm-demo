package io.huhu.leetcode.n740;

class DP implements Code {

    @Override
    public int deleteAndEarn(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }
        int[] _nums = new int[n + 1];
        for (int num : nums) {
            _nums[num] += num;
        }
        int[] f = new int[n + 3];
        for (int i = n; i >= 0; i--) {
            f[i] = Math.max(f[i + 1], f[i + 2] + _nums[i]);
        }
        return f[0];
    }

}
