package io.huhu.leetcode.n1218;

import io.huhu.AC;

@AC
class DynamicProgramming implements Code {

    @Override
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1, offset = 20000;
        int[] f = new int[40001];
        for (int num : arr) {
            f[num + offset] = f[num + offset - difference] + 1;
            ans = Math.max(ans, f[num + offset]);
        }
        return ans;
    }

}
