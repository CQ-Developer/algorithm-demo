package io.huhu.leetcode.n81;

/**
 * <h1>
 * 81.搜索旋转排序数组II
 * </h1>
 */
class Solution {

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            // 直接找到目标
            if (nums[mid] == target) {
                return true;
            }
            // 数组的前半部分有序的
            if (nums[start] < nums[mid]) {
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // 数组的后半部分有序
            else if (nums[start] > nums[mid]) {
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            // 不能确定数组的哪部分是有序的
            else {
                start++;
            }
        }
        return false;
    }

}
