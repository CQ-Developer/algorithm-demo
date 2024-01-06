package io.huhu.leetcode.bit.manipulation.easy.n762;

/**
 * <a href="https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/description/">二进制表示中质数个计算置位</a>
 */
class Solution {

    /**
     * 题目给定 right <= 10<sup>6</sup>, 则 right < 2<sup>20</sup>,
     * 也就是说二进制表示中的1的数量最多有19个, 相当于只需要判断小于等于19的所有质数即可.<br/>
     * 小于等于19的质数包含: 2、3、5、7、11、13、17、19.
     * 将其使用数组表示即可.
     */
    private final int[] prime = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            int bit = countBit(i);
            res += prime[bit];
        }
        return res;
    }

    /**
     * 统计二进制表示中1的个数
     */
    private int countBit(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += n & 1;
            n >>>= 1;
        }
        return cnt;
    }

}
