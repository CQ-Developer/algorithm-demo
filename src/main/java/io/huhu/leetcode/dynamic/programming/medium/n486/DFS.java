package io.huhu.leetcode.dynamic.programming.medium.n486;

class DFS implements Solution {

    @Override
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int p1 = dfs(nums, 0, nums.length - 1);
        int p2 = sum - p1;
        return p1 >= p2;
    }

    /**
     * p1的选择
     */
    private int dfs(int[] nums, int l, int r) {
        // 仅剩下一个数, p1一定选择
        if (l == r) {
            return nums[l];
        }
        // 仅剩下两个数组, p1一定选择最大结果
        if (l + 1 == r) {
            return Math.max(nums[l], nums[r]);
        }
        // 当前轮p1要不选择l, 要不选择r
        // 下一轮是p2选择, p2一定希望最大结果, 那么p1必然获得最小结果
        int a = nums[l] + Math.min(dfs(nums, l + 1, r - 1), dfs(nums, l + 2, r));
        int b = nums[r] + Math.min(dfs(nums, l + 1, r - 1), dfs(nums, l, r - 2));
        // p1选择最大结果
        return Math.max(a, b);
    }

}
