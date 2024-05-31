package io.huhu.leetcode.dynamic.programming.sumary.house.robber.n198;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">打家劫舍</a>
 */
class Solution {

    public int rob(int[] nums) {
        // 总共有n间房子
        int n = nums.length;
        // 偷0间房子的最大收益为0
        int[] dp = new int[n + 1];
        // 偷1间房子的最大收益为nums[0]
        dp[1] = nums[0];
        // 从偷2间房子开始计算
        for (int i = 2; i <= n; i++) {
            // 偷i间房子的最大收益:
            // 1.当前房子不偷的最大收益
            // 2.偷当前房子的收益 + 上1间房子没偷的最大收益
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

}
