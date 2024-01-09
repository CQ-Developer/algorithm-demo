package io.huhu.leetcode.bit.manipulation.easy.n1356;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits/description/">根据数字二进制下1的数目排序</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= arr.length <= 500</li>
     * <li>0 <= arr[i] <= 10<sup>4</sup></li>
     * </ul>
     */
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += countBit(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 100000;
        }
        return arr;
    }

    private int countBit(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

}
