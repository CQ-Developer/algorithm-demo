package io.huhu.huawei.od.s200.n9;

import java.util.Scanner;

/**
 * <a href="https://blog.csdn.net/shangyanaf/article/details/135119172">MELON的难题</a>
 */
class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // junit
        int result = resolve(nums);
        System.out.println(result);
    }

    public static int resolve(int[] nums) {
        int sum = sum(nums);
        // 数组不可能平分
        if (sum % 2 != 0) {
            return -1;
        }
        // 平分的目标
        int target = sum >> 1;
        // dp[i][j]表示从前i个雨花石中选出重量为j需要的雨花石数量
        int[][] dp = new int[nums.length + 1][target + 1];
        // 从前0个雨花石中选出重量不为0的雨花石, 不可能
        for (int j = 1; j <= target; j++) {
            // 不可能选择全部雨花石, 所以nums.length是一个不可能的值
            dp[0][j] = nums.length;
        }
        // 从前1个雨花石中选出重量不等于该雨花石, 不可能
        for (int j = 0; j <= target; j++) {
            if (j == nums[0]) {
                dp[1][j] = 1;
            } else {
                // 不可能选择全部雨花石, 所以nums.length是一个不可能的值
                dp[1][j] = nums.length;
            }
        }
        // 从前2个雨花石开始选
        for (int i = 2; i <= nums.length; i++) {
            // 重量从1开始, 不可能从前2个雨花石中选出重量为0的情况
            for (int j = 1, k = i - 1; j <= target; j++) {
                // 当前雨花石的重量大于目标j的, 不能选
                if (nums[k] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 选择当前雨花石或者不选, 取两者的最小值
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - nums[k]] + 1);
                }
            }
        }
        int res = dp[nums.length][target];
        return res == nums.length ? -1 : res;
    }

    private static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

}
