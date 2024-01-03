package io.huhu.leetcode.bit.manipulation.easy.n231;

/**
 * <a href="https://leetcode.cn/problems/power-of-two/description/">2的幂</a>
 */
public class Solution {

    /**
     * 方法一: n & (n - 1) == 0
     * n     = 8, 1000
     * n - 1 = 7, 0111
     *   1000
     * & 0111
     * ------
     *   0000 = 0
     * 方法二: n & (-n) == 0
     *  n =  8 (0000 0000 0000 0000 0000 0000 0000 1000)
     * -n = -8 (1111 1111 1111 1111 1111 1111 1111 1000)
     *   0000 0000 0000 0000 0000 0000 0000 1000
     * & 1111 1111 1111 1111 1111 1111 1111 1000
     * -----------------------------------------
     *   0000 0000 0000 0000 0000 0000 0000 1000 = 8
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
