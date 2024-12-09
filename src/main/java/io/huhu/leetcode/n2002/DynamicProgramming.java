package io.huhu.leetcode.n2002;

import io.huhu.AC;

@AC
class DynamicProgramming implements Solution {

    @Override
    public int maxProduct(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        // f[i]表示状态i的最长回文串的长度
        int[] f = new int[1 << n];
        // 高位
        for (int h = 0; h < n; h++) {
            // 一个字符形成回文串
            f[1 << h] = 1;
            // 低位
            for (int l = h - 1; l >= 0; l--) {
                /* 枚举高位到低位之间的所有状态
                 *
                 * 假设:
                 * 第0位是低位(0001),
                 * 第3位是高位(1000)
                 *
                 * 即枚举1001...1111之间的所有状态
                 * 1[00]1
                 * 1[01]1
                 * 1[10]1
                 * 1[11]1
                 *
                 * 共2^(3-0-1)种状态
                 * 即2^(h-l-1)种状态
                 */
                for (int b = 0; b < (1 << (h - l - 1)); b++) {
                    /*
                     * 假设
                     * 当前状态为b(二进制状态)
                     * 高位: 10000
                     * 低位: 00001
                     * 枚举1b1状态的所有可能: 10001 ... 11111
                     */
                    if (c[l] == c[h]) {
                        // f[1b1] = f[0b0] + 2
                        f[(b << (l + 1)) | (1 << l) | (1 << h)] = f[b << (l + 1)] + 2;
                    } else {
                        // f[1b1] = Math.max(f[1b0], f[0b1])
                        f[(b << (l + 1)) | (1 << l) | (1 << h)] = Math.max(f[(b << (l + 1)) | (1 << l)], f[(b << (l + 1)) | (1 << h)]);
                    }
                }
            }
        }
        // 不相交的回文串乘积
        int res = 0, len = 1 << n, mask = len - 1;
        for (int stat = 0; stat < len; stat++) {
            // f[0101] * f[1010]
            res = Math.max(res, f[stat] * f[stat ^ mask]);
        }
        return res;
    }

}
