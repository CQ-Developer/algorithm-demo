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
        int p1 = 0, p2 = 0;
        for (int i = n; i >= 0; i--) {
            int p = Math.max(p1, p2 + _nums[i]);
            p2 = p1;
            p1 = p;
        }
        return p1;
    }

}
