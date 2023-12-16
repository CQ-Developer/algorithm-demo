package io.huhu.leetcode.back.trace.n2397;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case_1() {
        int[][] matrix = {{0, 0, 0},
                          {1, 0, 1},
                          {0, 1, 1},
                          {0, 0, 1}};
        int numSelect = 2;
        Assertions.assertEquals(3, solution.maximumRows(matrix, numSelect));
    }

    @Test
    void case_2() {
        int[][] matrix = {{1},
                          {0}};
        int numSelect = 1;
        Assertions.assertEquals(2, solution.maximumRows(matrix, numSelect));
    }

    @Test
    void case_3() {
        int[][] matrix = {{1, 0, 0, 0, 0, 0, 0},
                          {0, 1, 0, 1, 1, 1, 1},
                          {0, 0, 0, 1, 0, 0, 1}};
        int numSelect = 5;
        Assertions.assertEquals(2, solution.maximumRows(matrix, numSelect));
    }

}
