package io.huhu.leetcode.back.trace.lcr.n102;

/**
 * <a href="https://leetcode.cn/problems/YaVDxD/description/">目标和</a>
 * <p>给定一个正整数数组nums和一个整数target
 * <p>向数组中的每个整数前添加'+'或'-', 然后串联起所有整数, 可以构造一个表达式:
 * <li>例如, nums = [2, 1], 可以在2之前添加'+', 在1之前添加'-', 然后串联起来得到表达式"+2-1"
 * <p>返回可以通过上述方法构造的、运算结果等于target的不同表达式的数目
 * <p>提示:
 * <li>1 <= nums.length <= 20
 * <li>0 <= nums[i] <= 1000
 * <li>0 <= sum[nums[i]] <= 1000
 * <li>-1000 <= target <= 1000
 */
class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return backTracing(nums, 0, target);
    }

    private int backTracing(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return backTracing(nums, i + 1, target + nums[i]) + backTracing(nums, i + 1, target - nums[i]);
    }

}
