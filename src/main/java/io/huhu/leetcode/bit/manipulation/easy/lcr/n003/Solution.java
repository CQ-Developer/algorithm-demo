package io.huhu.leetcode.bit.manipulation.easy.lcr.n003;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/w3tCBm/description/">比特位计数</a>
 */
class Solution {

    public int[] countBits(int n) {
        int[] a = new int[n + 1];
        dfs(1, 1, n, a);
        return a;
    }

    private void dfs(int i, int cnt, int n, int[] a) {
        if (i > n) {
            return;
        }
        a[i] = cnt;
        System.out.println(Arrays.toString(a));
        dfs(i << 1, cnt, n, a);
        dfs((i << 1) + 1, cnt + 1, n, a);
    }

}
