package io.huhu.leetcode.bit.manipulation.easy.n2859;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits/description/">计算K位置下标对应运算的和</a>
 */
class Solution {

    /**
     * <ul>
     * <li>1 <= nums.length <= 1000</li>
     * <li>1 <= nums[i] <= 10<sup>5</sup></li>
     * <li>0 <= k <= 10</li>
     * </ul>
     */
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (bitCount(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    /**
     * 统计二进制位1的个数
     */
    private int bitCount(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }

}
