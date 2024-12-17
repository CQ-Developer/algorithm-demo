package io.huhu.leetcode.n2305;

import io.huhu.AC;

import java.util.Arrays;

@AC
class DP implements Solution {

    @Override
    public int distributeCookies(int[] cookies, int k) {
        /*
         * f[i][j]表示前i个孩子分配饼干集合为j时的不公平程度最小值
         * g[j]表示饼干集合为j时的饼干总量
         *
         * 假设s为j的子集
         *
         * 如果 g[s] > f[i-1][j^s]
         * 说明给第i个孩子分配的饼干比前面的孩子多, 不公平程度为 g[s]
         *
         * 如果 g[s] <= f[i-1][j^s]
         * 说明给第i个孩子分配的饼干不比前面孩子的多, 不公平程度为 f[i-1][j^s]
         *
         * 综上所述, 给第i个孩子分配饼干集合s后, 前i个孩子的不公平程度为:
         * max( f[i-1][j^s], g[s] )
         *
         * 枚举j的所有子集s:
         * f[i][j] = min( f[i][j], max( f[i-1][j^s], g[s] ) )
         */
        int n = cookies.length, m = 1 << n;
        int[] g = new int[m];
        for (int i = 0; i < n; i++) {
            int j = 1 << i;
            for (int s = 0; s < j; s++) {
                g[j | s] = g[s] + cookies[i];
            }
        }
        int[] f = Arrays.copyOf(g, m);
        for (int i = 1; i < k; i++) {
            // 当前状态j
            for (int j = m - 1; j >= 1; j--) {
                // 枚举j的子集s
                for (int s = j; s > 0; s = (s - 1) & j) {
                    f[j] = Math.min(f[j], Math.max(f[j ^ s], g[s]));
                }
            }
        }
        return f[m - 1];
    }

}
