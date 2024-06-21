package io.huhu.leetcode.dynamic.programming.medium.n397;

/**
 * <h1>
 * <a href="https://leetcode.cn/problems/integer-replacement/description/">Integer Replacement</a>
 * </h1>
 * <p>Given a positive integer n, you can apply one of the following operations:</p>
 * <ul>
 * <li>if n is even, replace n with n / 2</li>
 * <li>if n is odd, replace n with either n + 1 or n - 1</li>
 * </ul>
 * <p>Return the minimum number of operations needed for n to become 1</p>
 */
class Solution {

    /**
     * 1 &lt;= n &lt;= 2<sup>31</sup> - 1
     */
    public int integerReplacement(int n) {
        long m = n;
        int ans = 0;
        /*
         * 如果将n看成一个二进制数, 那么就是怎么将数字变成最低位为1, 其他位为0
         * 偶数直接右移一位
         * 奇数的最低位一定为1, 分情况:
         * 次低位如果为1, 那么加1能消除连续的1, 除非是边界情况3
         * 次低位不为1, 那么减1能让最低位变为0
         *
         * 核心思想就是:
         * 偶数直接右移, 奇数尽量消除更多的1
         */
        while (m > 1) {
            if ((m & 1) == 0) {
                m >>= 1;
            } else {
                m += m != 3 && ((m >> 1) & 1) == 1 ? 1 : -1;
            }
            ans++;
        }
        return ans;
    }

}
