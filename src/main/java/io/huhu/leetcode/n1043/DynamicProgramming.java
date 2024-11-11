package io.huhu.leetcode.n1043;

class DynamicProgramming implements Code {

    @Override
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[k];
        for (int i = 0; i < n; i++) {
            int ans = 0, max = 0;
            for (int j = i; j >= 0 && j > i - k; j--) {
                max = Math.max(max, arr[j]);
                ans = Math.max(ans, max * (i - j + 1) + f[j % k]);
            }
            f[(i + 1) % k] = ans;
        }
        return f[n % k];
    }

}
