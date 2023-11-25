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
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        return dfs(nums, new boolean[nums.length], new int[k], 0, target);
    }

    private boolean dfs(int[] nums, boolean[] used, int[] groups, int k, int target) {
        if (k == groups.length) {
            return true;
        }
        // 剩余的组合不可能再凑出target
        if (k > 0 && groups[k] == 0) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (used[j]) {
                    continue;
                }
                sum += nums[j];
            }
            if (sum % (groups.length - k) != 0) {
                return false;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (used[i]) {
                continue;
            }
            // 之前的相同数字没有被使用, 那么当前使用它也不可能成功
            if (i < nums.length - 1 && nums[i] == nums[i + 1] && !used[i + 1]) {
                continue;
            }
            int num = groups[k] + nums[i];
            if (num > target) {
                continue;
            }
            if (num < target) {
                // 本层的所有剩余数字相加都小于target
                int remaining = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (used[j] || j == i) {
                        continue;
                    }
                    remaining += nums[j];
                }
                if (num + remaining < target) {
                    break;
                }
                // 当前数字加上最小的数字大于target
                int min = -1;
                for (int j = 0; j < nums.length; j++) {
                    if (used[j] || j == i) {
                        continue;
                    }
                    min = nums[j];
                    break;
                }
                if (min != -1 && num + min > target) {
                    break;
                }
            }
            groups[k] += nums[i];
            used[i] = true;
            if (dfs(nums, used, groups, groups[k] == target ? k + 1 : k, target)) {
                return true;
            }
            groups[k] -= nums[i];
            used[i] = false;
        }
        return false;
    }

}
