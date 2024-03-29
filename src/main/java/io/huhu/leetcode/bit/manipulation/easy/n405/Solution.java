package io.huhu.leetcode.bit.manipulation.easy.n405;

/**
 * <a href="https://leetcode.cn/problems/convert-a-number-to-hexadecimal/description/">数字转换为十六进制数</a>
 */
class Solution {

    private final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        int i = 7;
        char[] s = new char[8];
        while (num != 0) {
            s[i--] = table[num & 0xf];
            num >>>= 4;
        }
        return String.valueOf(s, i + 1, 7 - i);
    }

}
