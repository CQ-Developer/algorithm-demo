package io.huhu.leetcode.back.trace.n698;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/description/">698.划分为k个相等的子集</a>
 * 给定一个整数数组nums和一个正整数k, 找出是否有可能把这个数组分成k个非空子集, 其总合都相等.
 */
class Solution {

    /**
     * 1 <= k <= nums.length <= 16
     * 0 <= nums[i] < 10000
     * 每个元素的频率在[1,4]范围内
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 判断数组是否可能分成k组
        if (sum % k != 0) {
            return false;
        }
        // 每组的总合
        int target = sum / k;
        // 倒叙排序数组
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int num = nums[l];
            nums[l++] = nums[r];
            nums[r--] = num;
        }
        // 深度优先遍历
        return dfs(nums, 0, new boolean[nums.length], new int[k], 0, target);
    }

    /**
     * 深度优先遍历
     */
    private boolean dfs(int[] nums, int j, boolean[] used, int[] groups, int k, int target) {
        // 所有子集都找到了
        if (k == groups.length) {
            return true;
        }
        // groups[k] == 0 表示开始寻找一个新的子集, 那么从0开始找
        // 否则表示一个正在寻找中的子集, 那么从j开始找, 因为j之前的数字在上一层已经验证过了
        for (int i = groups[k] == 0 ? 0 : j; i < nums.length; i++) {
            // 如果当前数字使用过了那么跳过
            if (used[i]) {
                continue;
            }
            // 如果当前数字和上一个数字相同, 且上一个数字没有使用, 那么当前数字也不可能被使用
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 如果当前结果大于target, 那么跳过
            if (groups[k] + nums[i] > target) {
                continue;
            }
            // 回溯
            groups[k] += nums[i];
            used[i] = true;
            if (dfs(nums, i + 1, used, groups, groups[k] == target ? k + 1 : k, target)) {
                return true;
            }
            groups[k] -= nums[i];
            used[i] = false;
        }
        return false;
    }

}
