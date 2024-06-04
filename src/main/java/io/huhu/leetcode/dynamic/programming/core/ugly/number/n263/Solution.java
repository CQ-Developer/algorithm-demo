package io.huhu.leetcode.dynamic.programming.core.ugly.number.n263;

/**
 * <a href="https://leetcode.cn/problems/ugly-number/description/">丑数</a>
 */
class Solution {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] nums = {2, 3, 5};
        for (int num : nums) {
            while (n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }

}
