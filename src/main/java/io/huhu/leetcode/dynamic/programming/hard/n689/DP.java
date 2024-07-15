package io.huhu.leetcode.dynamic.programming.hard.n689;

class DP implements Solution {

    @Override
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        // 以i位置起长度为k的最大累加和
        int[] sums = new int[n];
        for (int l = 0, r = 0, sum = 0; r < n; r++) {
            sum += nums[r];
            if (r - l + 1 == k) {
                sums[l] = sum;
                sum -= nums[l];
                l++;
            }
        }
        // 0...i 范围上所有长度为k的子数组中 最大累加和子数组以什么位置开头
        int[] prefix = new int[n];
        for (int l = 1, r = k; r < n; l++, r++) {
            int p = prefix[r - 1];
            prefix[r] = sums[l] > sums[p] ? l : p;
        }
        // i...n-1 范围上所有长度为k的子数组中 最大累加子数组以什么位置开头
        int[] suffix = new int[n];
        suffix[n - k] = n - k;
        for (int l = n - k - 1; l >= 0; l--) {
            int s = suffix[l + 1];
            suffix[l] = sums[l] >= sums[s] ? l : s;
        }
        // 0...i-1   i...j   j+1...n-1
        int a = 0, b = 0, c = 0, max = 0;
        for (int i = k, j = i + k - 1; j < n - k; i++, j++) {
            int p = prefix[i - 1], s = suffix[j + 1];
            int sum = sums[p] + sums[i] + sums[s];
            if (sum > max) {
                max = sum;
                a = p;
                b = i;
                c = s;
            }
        }
        return new int[]{a, b, c};
    }

}
