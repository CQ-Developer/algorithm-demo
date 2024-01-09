package io.huhu.leetcode.bit.manipulation.easy.n1009;

/**
 * <a href="https://leetcode.cn/problems/complement-of-base-10-integer/description/">十进制整数的反码</a>
 */
class Solution {

    /**
     * <ul>
     * <li>0 <= N < 10<sup>9</sup></li>
     * <li>本题与476相同</li>
     * </ul>
     */
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 0, i = 0;
        while (n != 0) {
            if ((n & 1) == 0) {
                res |= 1 << i;
            }
            i++;
            n >>>= 1;
        }
        return res;
    }

}
