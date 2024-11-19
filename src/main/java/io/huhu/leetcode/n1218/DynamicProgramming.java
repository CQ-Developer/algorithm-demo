package io.huhu.leetcode.n1218;

import io.huhu.TLE;

@TLE
class DynamicProgramming implements Code {

    @Override
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        int[] f = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] + difference == arr[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                    break;
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

}
