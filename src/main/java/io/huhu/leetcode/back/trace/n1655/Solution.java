package io.huhu.leetcode.back.trace.n1655;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/distribute-repeating-integers/description/">
 * Distribute Repeating Integers
 * </a>
 */
class Solution {

    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] arr = new int[1001];
        for (int num : nums) {
            arr[num]++;
        }
        Arrays.sort(arr);
        Arrays.sort(quantity);
        return f(Arrays.copyOfRange(arr, arr.length - 50, arr.length), quantity, quantity.length - 1);
    }

    private boolean f(int[] nums, int[] quantity, int i) {
        if (i == -1) {
            return true;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                continue;
            }
            if (nums[j] >= quantity[i]) {
                nums[j] -= quantity[i];
                if (f(nums, quantity, i - 1)) {
                    return true;
                }
                nums[j] += quantity[i];
            }
        }
        return false;
    }

}
