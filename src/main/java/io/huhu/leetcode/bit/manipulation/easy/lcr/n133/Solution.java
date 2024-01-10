package io.huhu.leetcode.bit.manipulation.easy.lcr.n133;

/**
 * <a href="https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/description/">位1的个数</a>
 */
class Solution {

    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }

}
