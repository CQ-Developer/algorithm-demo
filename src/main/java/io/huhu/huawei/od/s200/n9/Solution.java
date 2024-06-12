package io.huhu.huawei.od.s200.n9;

import java.util.Arrays;
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
        int res = resolve(nums);
        System.out.println(res);
    }

    public static int resolve(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return -1;
        }
        Arrays.sort(nums);
        return dfs(nums, 0, 0, sum >> 1, 0);
    }

    private static int dfs(int[] nums, int i, int sum, int target, int cnt) {
        if (sum > target) {
            return Integer.MAX_VALUE;
        }
        if (sum == target) {
            return cnt;
        }
        if (i == nums.length) {
            return Integer.MAX_VALUE;
        }
        // 必然不选
        if (sum + nums[i] > target) {
            return dfs(nums, i + 1, sum, target, cnt);
        }
        int a = dfs(nums, i + 1, sum, target, cnt);
        int b = dfs(nums, i + 1, sum + nums[i], target, cnt + 1);
        return Math.min(a, b);
    }

}
