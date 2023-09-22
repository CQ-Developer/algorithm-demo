package io.huhu.leetcode.n41;

/**
 * <h1>缺失的第一个正数</h1>
 * <p>给你一个未排序的整数数组nums，请你找出其中没有出现的最小的正整数。</p>
 * <p>请你实现时间复杂度为O(n)并且只使用常数级别额外空间的解决方案。</p>
 */
class Solution {

    /**
     * <h2>测试条件</h2>
     * <p>1 <= nums.length <= 5 * 10<sup>5</sup></p>
     * <p>-2<sup>31</sup> nums[i] <= 2<sup>31</sup> - 1</p>
     * <br>
     *
     * <p>示例一：</p>
     * <p>输入：[1, 2, 0]</p>
     * <p>输出：3</p>
     * <br>
     *
     * <p>示例二：</p>
     * <p>输入：[3, 4, -1, 1]</p>
     * <p>输出：2</p>
     * <br>
     *
     * <p>示例三：</p>
     * <p>输入：[7, 8, 9, 11, 12]</p>
     * <p>输出：1</p>
     * <br>
     *
     * @param nums 未排序的整数数组
     * @return 最小正整数
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                int num = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
