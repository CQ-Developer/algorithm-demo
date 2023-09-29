package io.huhu.leetcode.n75;

/**
 * <h1>
 * 75.颜色分类
 * </h1>
 *
 * <p>
 * 给定一个包含红色、白色和蓝色，共n个元素的数组nums，原地对他们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排序。
 * <br/>
 * 我们使用整数0、1、2分别表示红色、白色、蓝色。
 * <br/>
 * 必须在不适用库内置的sort函数的情况下解决这个问题。
 * </p>
 *
 * <p>
 * 示例一：
 * <br/>
 * 输入：nums=[2,0,2,1,1,0]
 * <br/>
 * 输出：[0,0,1,1,2,2]
 * </p>
 *
 * <p>
 * 示例二：
 * <br/>
 * 输入：nums=[2,0,1]
 * <br/>
 * 输出：[0,1,2]
 * </p>
 *
 * <p>
 * 提示：
 * <br/>
 * n ==nums.length
 * <br/>
 * 1 <= n <= 300
 * <br/>
 * nums[i]为0、1、2
 * </p>
 */
class Solution {

    /**
     * <p>
     * 思路一：使用快速排序
     * <pre>{@code
     * public void sortColors(int[] nums) {
     *     if (nums.length > 1) {
     *         sortColors(nums, 0, nums.length - 1);
     *     }
     * }
     *
     * private void sortColors(int[] nums, int start, int end) {
     *     if (start < end) {
     *         int left = start;
     *         int pivot = nums[start];
     *         int right = end;
     *         while (left < right) {
     *             while (left < right && nums[right] >= pivot) {
     *                 right--;
     *             }
     *             while (left < right && nums[left] <= pivot) {
     *                 left++;
     *             }
     *             swap(nums, left, right);
     *         }
     *         swap(nums, start, right);
     *         sortColors(nums, start, right - 1);
     *         sortColors(nums, left + 1, end);
     *     }
     * }
     *
     * private void swap(int[] nums, int i, int j) {
     *     if (i != j) {
     *         int t = nums[i];
     *         nums[i] = nums[j];
     *         nums[j] = t;
     *     }
     * }
     * }</pre>
     * 性能是最好的，但是失去了题目想表达的语义。
     * </p>
     *
     * <p>
     * 思路二：使用三指针计数，再遍历填充数据。
     * </p>
     */
    public void sortColors(int[] nums) {
        int r = 0;
        int w = 0;
        int b = 0;
        for (int num : nums) {
            switch (num) {
                case 0 -> r++;
                case 1 -> w++;
                case 2 -> b++;
                default -> {}
            }
        }
        int i = 0;
        while (r > 0) {
            nums[i++] = 0;
            r--;
        }
        while (w > 0) {
            nums[i++] = 1;
            w--;
        }
        while (b > 0) {
            nums[i++] = 2;
            b--;
        }
    }

}
