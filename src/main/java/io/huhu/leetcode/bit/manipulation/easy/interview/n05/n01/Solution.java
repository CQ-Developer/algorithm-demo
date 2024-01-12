package io.huhu.leetcode.bit.manipulation.easy.interview.n05.n01;

/**
 * <a href="https://leetcode.cn/problems/insert-into-bits-lcci/description/">插入</a>
 */
class Solution {

    public int insertBits(int N, int M, int i, int j) {
        for (int p = i; p <= j; p++, M >>>= 1) {
            int mask = 1 << p;
            if ((M & 1) == 1) {
                N |= mask;
            } else {
                N &= ~mask;
            }
        }
        return N;
    }

}
