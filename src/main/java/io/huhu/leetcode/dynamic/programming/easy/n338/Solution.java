package io.huhu.leetcode.dynamic.programming.easy.n338;

/**
 * <a href="https://leetcode.cn/problems/counting-bits/description/">比特位计数</a>
 */
class Solution {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

}
