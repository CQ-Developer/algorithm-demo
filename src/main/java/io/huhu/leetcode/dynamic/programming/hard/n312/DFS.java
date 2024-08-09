package io.huhu.leetcode.dynamic.programming.hard.n312;

import java.util.Arrays;

class DFS implements Solution {

    @Override
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);
        int[][] f = new int[n + 1][n + 1];
        for (int[] a : f) {
            Arrays.fill(a, -1);
        }
        return dfs(arr, 1, n, f);
    }

    private int dfs(int[] nums, int l, int r, int[][] f) {
        if (f[l][r] != -1) {
            return f[l][r];
        }
        if (l == r) {
            return nums[l - 1] * nums[l] * nums[l + 1];
        }
        f[l][r] = Math.max(
                // 选择 l 位置最后打爆
                nums[l - 1] * nums[l] * nums[r + 1] + dfs(nums, l + 1, r, f),
                // 选择 r 位置最后打爆
                nums[l - 1] * nums[r] * nums[r + 1] + dfs(nums, l, r - 1, f));
        // 选择 (l,r) 位置最后打爆
        for (int i = l + 1; i < r; i++) {
            f[l][r] = Math.max(f[l][r], dfs(nums, l, i - 1, f) + nums[l - 1] * nums[i] * nums[r + 1] + dfs(nums, i + 1, r, f));
        }
        return f[l][r];
    }

}
