package io.huhu.leetcode.topological.sort.n851;

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
    void test_1() {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        int[] actual = solution.loudAndRich(richer, quiet);
        int[] expected = {5, 5, 2, 5, 4, 5, 6, 7};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void test_2() {
        int[][] richer = {};
        int[] quiet = {0};
        int[] actual = solution.loudAndRich(richer, quiet);
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, actual);
    }

}
