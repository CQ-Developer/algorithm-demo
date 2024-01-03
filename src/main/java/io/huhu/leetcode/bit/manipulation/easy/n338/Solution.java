package io.huhu.leetcode.bit.manipulation.easy.n338;

/**
 * <a href="https://leetcode.cn/problems/counting-bits/description/">比特位计算</a>
 */
class Solution {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

}
