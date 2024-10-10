package io.huhu.leetcode.n377;

class DFS implements Code {

    @Override
    public int combinationSum4(int[] nums, int target) {
        return f(nums, target);
    }

    /**
     * 每一轮可以选择所有数字
     */
    private int f(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int ans = 0;
        for (int num : nums) {
            if (num <= target) {
                ans += f(nums, target - num);
            }
        }
        return ans;
    }

}
