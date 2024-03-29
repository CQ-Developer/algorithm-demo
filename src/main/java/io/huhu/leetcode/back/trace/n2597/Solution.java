package io.huhu.leetcode.back.trace.n2597;

/**
 * <a href="https://leetcode.cn/problems/the-number-of-beautiful-subsets/description/">美丽子集的数目</a>
 * <p>给你一个由正整数组成的数组nums和一个正整数k
 * <p>如果nums的子集中, 任意两个整数的绝对差均不等于k, 则认为该子数组是一个美丽子集
 * <p>返回数组nums中非空且美丽的子集数目
 * <p>nums的子集定义为: 可以经由nums删除某些元素(也可能不删除)得到的一个数组.
 * 只有在删除元素时选择的索引不同的情况下, 两个子集才会被视作是不同的子集
 */
class Solution {

    private int res = -1;

    /**
     * 提示:
     * <ul>
     * <li>1 <= nums.length <= 20
     * <li>1 <= nums[i], k <= 1000
     * </ul>
     */
    public int beautifulSubsets(int[] nums, int k) {
        dfs(nums, 0, new int[2 * k + 1001], k);
        return res;
    }

    /**
     * 深度优先遍历 + 回溯算法
     */
    private void dfs(int[] nums, int s, int[] path, int k) {
        if (s <= nums.length) {
            res++;
            if (s == nums.length) {
                return;
            }
        }
        for (int i = s; i < nums.length; i++) {
            int x = nums[i] + k;
            if (path[x - k] == 0 && path[x + k] == 0) {
                path[x]++;
                dfs(nums, i + 1, path, k);
                path[x]--;
            }
        }
    }

}
