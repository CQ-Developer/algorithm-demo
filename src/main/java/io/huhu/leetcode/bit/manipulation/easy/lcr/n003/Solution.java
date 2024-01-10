package io.huhu.leetcode.bit.manipulation.easy.lcr.n003;

/**
 * <a href="https://leetcode.cn/problems/w3tCBm/description/">比特位计数</a>
 */
class Solution {

    public int[] countBits(int n) {
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = a[i >> 1] + (i & 1);
        }
        return a;
    }

}
