package io.huhu.leetcode.n526;

import java.util.Arrays;

class DP implements Code {

    @Override
    public int countArrangement(int n) {
        int m = 1 << (n + 1);
        int[] pre = new int[m], cur = new int[m];
        Arrays.fill(pre, 1);
        for (int i = 1; i <= n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                for (int num = 1; num <= n; num++) {
                    if (((1 << num) & j) == 0 && (i % num == 0 || num % i == 0)) {
                        cur[j] += pre[(1 << num) | j];
                    }
                }
            }
            for (int j = 0; j < m; j++) {
                pre[j] = cur[j];
                cur[j] = 0;
            }
        }
        return pre[0];
    }

}
