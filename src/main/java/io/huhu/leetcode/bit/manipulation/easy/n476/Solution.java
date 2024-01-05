package io.huhu.leetcode.bit.manipulation.easy.n476;

/**
 * <a href="https://leetcode.cn/problems/number-complement/description/">数字的补数</a>
 */
class Solution {

    /**
     * <p>核心思路: 生成一个和num位数相同, 且每一位都是1的数, 然后进行异或.</p>
     * <p>异或运算: 相同为0, 相异为1</p>
     */
    public int findComplement(int num) {
        int mask = 1;
        while (mask < num) {
            mask <<= 1;
            mask |= 1;
        }
        return mask ^ num;
    }

}
