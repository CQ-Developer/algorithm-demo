package io.huhu.leetcode.bit.manipulation.easy.n645;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/set-mismatch/description/">错误的集合</a>
 */
class Solution {

    /**
     * <p>方法一: 使用字典进行计数.
     * 丢失的数字计数为0，重复的数字计数为2</p>
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
     * <br/>
     * <p>方法二: 使用数学方法.
     * 重复数字 = sum(nums) - sum(去重nums);
     * 丢失数字 = sum(1~n) - sum(去重nums)</p>
     * <pre>{@code
     * // 使用lambda表达式
     * public int[] findErrorNums(int[] nums) {
     *     int a = IntStream.of(nums).sum() - IntStream.of(nums).distinct().sum();
     *     int b = IntStream.rangeClosed(1, nums.length).sum() - IntStream.of(nums).distinct().sum();
     *     return new int[]{a, b};
     * }
     * // 不使用lambda表达式
     * public int[] findErrorNums(int[] nums) {
     *     Arrays.sort(nums);
     *     int sum = 0;
     *     for (int i = 0; i < nums.length; i++) {
     *         if (i > 0 && nums[i] == nums[i - 1]) {
     *             continue;
     *         }
     *         sum += nums[i];
     *     }
     *     int a = 0;
     *     for (int num : nums) {
     *         a += num;
     *     }
     *     int b = 0;
     *     for (int num = 1; num <= nums.length; num++) {
     *         b += num;
     *     }
     *     return new int[]{a - sum, b - sum};
     * }
     * }</pre>
     */
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            sum += nums[i];
        }
        int a = 0;
        for (int num : nums) {
            a += num;
        }
        int b = 0;
        for (int num = 1; num <= nums.length; num++) {
            b += num;
        }
        return new int[]{a - sum, b - sum};
    }

}
