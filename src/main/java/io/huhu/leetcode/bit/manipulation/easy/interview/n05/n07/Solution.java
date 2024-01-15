package io.huhu.leetcode.bit.manipulation.easy.interview.n05.n07;

/**
 * <a href="https://leetcode.cn/problems/exchange-lcci/description/">配对交换</a>
 */
class Solution {

    public int exchangeBits(int num) {
        // 取出奇数位左移一位
        int odd = (num & 0x55555555) << 1;
        // 取出偶数位右移一位
        int even = (num & 0xaaaaaaaa) >>> 1;
        // 奇数位和偶数位合并
        return odd | even;
    }

}
