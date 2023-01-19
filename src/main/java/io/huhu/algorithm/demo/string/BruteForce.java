package io.huhu.algorithm.demo.string;

/**
 * BF算法: 暴力匹配算法, 也称为朴素匹配算法.
 * 特点: 简单直接, 性能不高.
 * 如果模式串长度为m, 主串长度为n, 那么在主串中就会有n-m+1个长度为m的子串.
 * 只需要暴力的对比这n-m+1个子串与模式串, 就可以找出主串与模式串匹配的子串.
 */
public class BruteForce {

    /**
     * 返回第一个匹配的起始下标
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 子串
     * @param m 子串长度
     * @return 第一个匹配的起始下标
     */
    public int bf(char[] a, int n, char[] b, int m) {
        for (int i = 0; i < n - m; i++) {
            // j表示当前子串的下标
            int j = 0;
            while (j < m) {
                if (a[i + j] != b[j]) {
                    break;
                }
                j++;
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

}
