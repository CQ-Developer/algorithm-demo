package io.huhu.leetcode.bit.manipulation.easy.n868;

/**
 * <a href="">二进制间距</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= n <= 10<sup>5</sup></li>
     * </ul>
     */
    public int binaryGap(int n) {
        int res = 0, i = 0, j = -1;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (j != -1) {
                    res = Math.max(res, i - j);
                }
                j = i;
            }
            n >>>= 1;
            i++;
        }
        return res;
    }

}
