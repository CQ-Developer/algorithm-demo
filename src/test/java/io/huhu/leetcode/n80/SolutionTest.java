package io.huhu.leetcode.n80;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void removeDuplicates1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        assertEquals(5, solution.removeDuplicates(nums));
        int[] expected = {1, 1, 2, 2, 3};
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, 5));
    }

    @Test
    void removeDuplicates2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        assertEquals(7, solution.removeDuplicates(nums));
        int[] expected = {0, 0, 1, 1, 2, 3, 3};
        assertArrayEquals(expected, Arrays.copyOfRange(nums, 0, 7));
    }

}
