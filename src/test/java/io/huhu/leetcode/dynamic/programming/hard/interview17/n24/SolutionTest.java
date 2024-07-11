package io.huhu.leetcode.dynamic.programming.hard.interview17.n24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SolutionTest {

    static Solution solution;

    @BeforeAll
    static void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int[][] matrix = {
                {-1, 0},
                {0, -1}
        };
        int[] expect = {0, 1, 0, 1};
        Assertions.assertArrayEquals(expect, solution.getMaxMatrix(matrix));
    }

    @Test
    void test_2() {
        int[][] matrix = {
                {9, -8, 1, 3, -2},
                {-3, 7, 6, -2, 4},
                {6, -4, -4, 8, -7}
        };
        int[] expect = {0, 0, 2, 3};
        Assertions.assertArrayEquals(expect, solution.getMaxMatrix(matrix));
    }

}
