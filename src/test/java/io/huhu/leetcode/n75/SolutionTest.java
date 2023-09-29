package io.huhu.leetcode.n75;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void sortColors_1() {
        int[] expected = {0, 0, 1, 1, 2, 2};
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    void sortColors() {
        int[] expected = {0, 1, 2};
        int[] nums = {2, 0, 1};
        solution.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

}
