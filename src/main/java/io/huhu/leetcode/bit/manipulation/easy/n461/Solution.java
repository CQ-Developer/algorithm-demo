package io.huhu.leetcode.bit.manipulation.easy.n461;

/**
 * <a href="https://leetcode.cn/problems/hamming-distance/description/">汉明距离</a>
 */
class Solution {

    /**
     * 异或运算: 相同为0, 相异为1
     */
    public int hammingDistance(int x, int y) {
        int res = 0, a = x ^ y;
        while (a != 0) {
            a &= (a - 1);
            res++;
        }
        return res;
    }

}
