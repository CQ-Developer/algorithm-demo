package io.huhu.leetcode.dynamic.programming.hard.n329;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {

    Solution solution;

    abstract void setup();

    @Test
    void test1() {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        Assertions.assertEquals(4, solution.longestIncreasingPath(matrix));
    }

    @Test
    void test2() {
        int[][] matrix = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        Assertions.assertEquals(4, solution.longestIncreasingPath(matrix));
    }

}
