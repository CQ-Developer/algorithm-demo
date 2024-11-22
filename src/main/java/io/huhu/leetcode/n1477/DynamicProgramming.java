package io.huhu.leetcode.n1477;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // f[i]表示[0...i)范围上和为target的子数组最短长度
        int[] f = new int[n + 1];
        int ans = f[0] = n + 1;
        for (int l = 0, r = 0, sum = 0; r < n; r++) {
            // 滑动窗口计算[l...r]范围上的子数组和
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l++];
            }
            // [l...r]范围上子数组的和为target
            if (sum == target) {
                // len为[l...r]范围上子数组的长度
                int len = r - l + 1;
                // f[l]表示[0...l)范围上和为target的子数组最短长度
                ans = Math.min(ans, len + f[l]);
                f[r + 1] = Math.min(f[r], len);
            } else {
                // [l...r]范围上未找到和为target的子数组
                f[r + 1] = f[r];
            }
        }
        return ans > n ? -1 : ans;
    }

}
