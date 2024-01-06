package io.huhu.leetcode.bit.manipulation.easy.n762;

/**
 * <a href="https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/description/">二进制表示中质数个计算置位</a>
 */
class Solution {

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += (0xa28ac & (1 << countBit(i))) != 0 ? 1 : 0;
        }
        return res;
    }

    /**
     * 统计二进制表示中1的个数
     */
    private int countBit(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }

}
