package io.huhu.leetcode.bit.manipulation.easy.n645;

import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.cn/problems/set-mismatch/description/">错误的集合</a>
 */
class Solution {

    /**
     * <p>方法一：使用字典进行计数。丢失的数字计数为0，重复的数字计数为2</p>
     * <pre>{@code
     * public int[] findErrorNums(int[] nums) {
     *     int[] dict = new int[nums.length + 1];
     *     for (int i : nums) {
     *         dict[i]++;
     *     }
     *     int[] res = new int[2];
     *     for (int i = 1; i < dict.length; i++) {
     *         if (dict[i] == 2) {
     *             res[0] = i;
     *         }
     *         if (dict[i] == 0) {
     *             res[1] = i;
     *         }
     *     }
     *     return res;
     * }
     * }</pre>
     */
    public int[] findErrorNums(int[] nums) {
        int a = IntStream.of(nums).sum() - IntStream.of(nums).distinct().sum();
        int b = IntStream.rangeClosed(1, nums.length).sum() - IntStream.of(nums).distinct().sum();
        return new int[]{a, b};
    }

}
