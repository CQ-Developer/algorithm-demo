package io.huhu.leetcode.bit.manipulation.easy.interview.n05.n01;

/**
 * <a href="https://leetcode.cn/problems/insert-into-bits-lcci/description/">插入</a>
 */
class Solution {

    public int insertBits(int N, int M, int i, int j) {
        int mask = (-1 << j << 1) ^ ((1 << i) - 1);
        return N & mask | (M << i);
    }

}
