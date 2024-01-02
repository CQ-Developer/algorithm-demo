package io.huhu.leetcode.bit.manipulation.easy.n190;

/**
 * <a href="https://leetcode.cn/problems/reverse-bits/description/">颠倒二进制位</a>
 */
class Solution {

    /**
     * @see java.lang.Integer#reverse(int)
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            // n & 1 相当于每次取n的最后一位
            // 将最后一位左移到31-i的位置, 注意第1位是符号位, 所以此处为31-i
            // res 每次都和最后一位进行或运算, 相当于将最后一位放到了第31-i位
            res |= (n & 1) << (31 - i);
            // 将n右移一位以获得下一位
            // 注意使用无符号右移, 让高位补0而不是补1
            n >>>= 1;
        }
        return res;
    }

}
