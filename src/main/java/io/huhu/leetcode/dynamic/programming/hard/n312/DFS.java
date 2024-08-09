package io.huhu.leetcode.dynamic.programming.hard.n312;

class DFS implements Solution {

    @Override
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, n);
        return dfs(arr, new boolean[n + 2], nums.length);
    }

    private int dfs(int[] nums, boolean[] used, int n) {
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            if (used[i]) {
                continue;
            }
            int l = i - 1;
            while (nums[l] == 0) {
                l--;
            }
            int r = i + 1;
            while (nums[r] == 0) {
                r++;
            }
            int c = nums[l] * nums[i] * nums[r];
            nums[i] = 0;
            used[i] = true;
            ans = Math.max(ans, dfs(nums, used, n - 1) + c);
            nums[i] = c / nums[l] / nums[r];
            used[i] = false;
        }
        return ans;
    }

}
