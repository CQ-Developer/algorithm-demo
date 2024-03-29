package io.huhu.leetcode.bit.manipulation.easy.n342;

/**
 * <a href="https://leetcode.cn/problems/power-of-four/description/">4的幂</a>
 */
class Solution {

    /**
     * <p>核心思路: 假设n是4的幂, 那么n一定是2的幂.
     * 可以先判断n是否是2的幂, 再判断是否是4的幂.</p>
     * <br/>
     * <p>方法一: 模运算</p>
     * <pre>{@code
     * // 如果n是4的幂，那么n % 3 == 1
     * public boolean isPowerOfFour(int n) {
     *     return n % 3 == 1 && (n & (n - 1)) == 0;
     * }
     * }</pre>
     * <br/>
     * <p>方法二: 与运算</p>
     * <p>如果n是4的幂, 那么n的二进制表示中一定只有一个1, 其位值变化如下</p>
     * <pre>
     *   1  0000 0000 0000 0000 0000 0000 0000 0001
     *   4  0000 0000 0000 0000 0000 0000 0000 0100
     *  16  0000 0000 0000 0000 0000 0000 0001 0000
     *  64  0000 0000 0000 0000 0000 0000 0100 0000
     * 256  0000 0000 0000 0000 0000 0001 0000 0000
     * 1024 0000 0000 0000 0000 0000 0100 0000 0000
     * 4096 0000 0000 0000 0000 0001 0000 0000 0000
     * </pre>
     * <p>假设最后一位是第0位, 那么1出现的位置全部都是偶数位, 例如2、4、6、8,
     * 因此构造一个数字, 让其第0位为0, 奇数位为1, 偶数位为0, 得到{@code 10101010101010101010101010101010},
     * 其十六进制表示为{@code 0xaaaaaaaa}, 则n若是4的幂, 则{@code n & 0xaaaaaaaa == 0}</p>
     * <p>代码如下:</p>
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

}
