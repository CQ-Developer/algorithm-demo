package io.huhu.leetcode.n740;

class DFS implements Code {

    @Override
    public int deleteAndEarn(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }
        int[] earns = new int[n + 1];
        for (int num : nums) {
            earns[num] += num;
        }
        return f(earns, 0);
    }

    private int f(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        return Math.max(f(nums, i + 1), f(nums, i + 2) + nums[i]);
    }

}
