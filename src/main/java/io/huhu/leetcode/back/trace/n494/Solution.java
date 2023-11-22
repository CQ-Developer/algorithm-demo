package io.huhu.leetcode.back.trace.n494;

/**
 * <a href="https://leetcode.cn/problems/target-sum/description/">494.目标和</a>
 * 给你一个非负整数数组nums和一个整数target.
 * 向数组中的每个整数前添加+或-, 然后串联起来所有整数, 可以构成一个表达式:
 * 例如, nums=[2,1], 可以在2之前添加+, 在1之前添加-, 然后串联起来得到表达式"+2-1".
 * 返回可以通过上述方法构成的, 运算结果等于target的不同表达式的数目.
 */
class Solution {

    /**
     * 1 <= nums.length <= 20
     * 0 <= nums[i] <= 1000
     * 0 <= sum(nums[i]) <= 1000
     * -1000 <= target <= 1000
     */
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    /**
     * 深度优先遍历
     */
    private int dfs(int[] nums, int i, int sum, int target) {
        if (i >= nums.length) {
            return sum == target ? 1 : 0;
        }
        return dfs(nums, i + 1, sum - nums[i], target) + dfs(nums, i + 1, sum + nums[i], target);
    }

}
