package io.huhu.leetcode.bit.manipulation.easy.n1356;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void sortByBits_1() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {0, 1, 2, 4, 8, 3, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solution.sortByBits(arr));
    }

    @Test
    void sortByBits_2() {
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        int[] expected = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        Assertions.assertArrayEquals(expected, solution.sortByBits(arr));
    }

    @Test
    void sortByBits_3() {
        int[] arr = {10000, 10000};
        int[] expected = {10000, 10000};
        Assertions.assertArrayEquals(expected, solution.sortByBits(arr));
    }

    @Test
    void sortByBits_4() {
        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
        int[] expected = {2, 3, 5, 17, 7, 11, 13, 19};
        Assertions.assertArrayEquals(expected, solution.sortByBits(arr));
    }

    @Test
    void sortByBits_5() {
        int[] arr = {10, 100, 1000, 10000};
        int[] expected = {10, 100, 10000, 1000};
        Assertions.assertArrayEquals(expected, solution.sortByBits(arr));
    }

}
