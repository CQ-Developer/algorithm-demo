package io.huhu.leetcode.n1027;

import java.util.Arrays;

class DynamicProgramming implements Code {

    @Override
    public int longestArithSeqLength(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int ans = 1;
        int[] f = new int[max + 1];
        for (int dif = -max; dif <= max; dif++) {
            Arrays.fill(f, -1);
            for (int cur : nums) {
                int pre = cur - dif;
                if (pre >= 0 && pre <= max && f[pre] != -1) {
                    f[cur] = Math.max(f[cur], f[pre] + 1);
                    ans = Math.max(ans, f[cur]);
                }
                f[cur] = Math.max(f[cur], 1);
            }
        }
        return ans;
    }

}
