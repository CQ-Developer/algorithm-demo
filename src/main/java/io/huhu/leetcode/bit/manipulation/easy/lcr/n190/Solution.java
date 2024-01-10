package io.huhu.leetcode.bit.manipulation.easy.lcr.n190;

/**
 * <a href="https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/description/">加密运算</a>
 */
class Solution {

    public int encryptionCalculate(int dataA, int dataB) {
        while (dataB != 0) {
            int c = (dataA & dataB) << 1;
            dataA ^= dataB;
            dataB = c;
        }
        return dataA;
    }

}
