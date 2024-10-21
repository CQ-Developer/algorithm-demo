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
        int p2 = _nums[0], p1 = Math.max(_nums[0], _nums[1]);
        for (int i = 2; i <= n; i++) {
            int p = Math.max(p1, p2 + _nums[i]);
            p2 = p1;
            p1 = p;
        }
        return p1;
    }

}
