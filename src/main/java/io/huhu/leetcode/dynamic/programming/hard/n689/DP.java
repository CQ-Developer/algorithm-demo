package io.huhu.leetcode.dynamic.programming.hard.n689;

class DP implements Solution {

    @Override
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        int[] sums = new int[n];
        for (int l = 0, r = 0, sum = 0; r < n; r++) {
            sum += nums[r];
            if (r - l + 1 == k) {
                sums[l] = sum;
                sum -= nums[l];
                l++;
            }
        }

        int[] pre = new int[n];
        for (int l = 1, r = k; r < n; l++, r++) {
            pre[r] = sums[l] > sums[pre[r - 1]] ? l : pre[r - 1];
        }

        int[] suf = new int[n];
        suf[n - k] = n - k;
        for (int l = n - k - 1; l >= 0; l--) {
            suf[l] = sums[l] >= sums[suf[l + 1]] ? l : suf[l + 1];
        }

        int a = 0, b = 0, c = 0, max = 0;
        for (int i = k, j = i + k - 1; j < n - k; i++, j++) {
            int p = pre[i - 1], s = suf[j + 1];
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
