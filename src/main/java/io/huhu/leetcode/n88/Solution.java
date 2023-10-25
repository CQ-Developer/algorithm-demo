package io.huhu.leetcode.n88;

/**
 * <h1>
 * 88.合并两个有序数组
 * </h1>
 *
 * <p>
 * 给你两个按非递减顺序片列的整数数组nums1合nums2，另有两个数组m合n，分别表示nums1合nums2中的元素数目。
 * <br/>
 * 请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 * <br/>
 * 注意：最终合并后数组不应由函数返回，而是存储在数组nums1中，为了应对这种情况，nums1的初始长度为m+n，其中前m个元素表示应合并的元素，后n个元素为0，应忽略。nums2的长度为n。
 * </p>
 *
 * <p>
 * nums1.length == m + n
 * <br/>
 * nusm2.length == n
 * <br/>
 * 0 <= m, n <= 200
 * <br/>
 * 1 <= m + n <= 200
 * <br/>
 * -10<sup>5</sup> <= nums1[i], nums2[j] <= 10<sup>5</sup>
 * </p>
 */
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int c = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[c--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[c--] = nums2[j--];
        }
    }

}
