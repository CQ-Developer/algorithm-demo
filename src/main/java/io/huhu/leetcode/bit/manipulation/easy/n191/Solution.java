package io.huhu.leetcode.bit.manipulation.easy.n191;

/**
 * <a href="https://leetcode.cn/problems/number-of-1-bits/description/">位1的个数</a>
 */
class Solution {

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

}
