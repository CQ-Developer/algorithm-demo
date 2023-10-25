package io.huhu.leetcode.n88;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void merge1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        int[] expected = {1, 2, 2, 3, 5, 6};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void merge2() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        solution.merge(nums1, m, nums2, n);
        int[] expected = {1};
        assertArrayEquals(expected, nums1);
    }

    @Test
    void merge3() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        solution.merge(nums1, m, nums2, n);
        int[] expected = {1};
        assertArrayEquals(expected, nums1);
    }

}