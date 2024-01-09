package io.huhu.leetcode.bit.manipulation.easy.n1720;

/**
 * <a href="https://leetcode.cn/problems/decode-xored-array/description/">解码异或后的数组</a>
 */
class Solution {

    /**
     * <ul>
     * <li>2 <= n <= 10<sup>4</sup></li>
     * <li>encoded.length == n - 1</li>
     * <li>0 <= encoded[i] <= 10<sup>5</sup></li>
     * <li>0 <= first <= 10<sup>5</sup></li>
     * </ul>
     */
    public int[] decode(int[] encoded, int first) {
        int[] decode = new int[encoded.length + 1];
        decode[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            decode[i + 1] = encoded[i] ^ decode[i];
        }
        return decode;
    }

}
