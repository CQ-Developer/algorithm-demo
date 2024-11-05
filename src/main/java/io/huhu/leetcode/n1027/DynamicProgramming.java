package io.huhu.leetcode.n1027;

import java.util.Arrays;

class DynamicProgramming implements Code {

    @Override
    public int longestArithSeqLength(int[] nums) {
        int n = Integer.MIN_VALUE;
        for (int num : nums) {
            n = Math.max(n, num);
        }
        int ans = 2;
        // 枚举所有公差
        int[] f = new int[n + 1];
        for (int d = -n; d <= n; d++) {
            Arrays.fill(f, 0);
            for (int c : nums) {
                int p = c - d;
                // 越界则形成长度为1的等差序列
                f[c] = p >= 0 && p <= n ? f[p] + 1 : 1;
                ans = Math.max(ans, f[c]);
            }
        }
        return ans;
    }

}
