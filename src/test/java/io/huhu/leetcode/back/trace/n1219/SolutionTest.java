package io.huhu.leetcode.back.trace.n1219;

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
    void getMaximumGold1() {
        int[][] grid = {{0, 6, 0},
                        {5, 8, 7},
                        {0, 9, 0}};
        Assertions.assertEquals(24, solution.getMaximumGold(grid));
    }

    @Test
    void getMaximumGold2() {
        int[][] grid = {{1, 0, 7},
                        {2, 0, 6},
                        {3, 4, 5},
                        {0, 3, 0},
                        {9, 0, 20}};
        Assertions.assertEquals(28, solution.getMaximumGold(grid));
    }

    @Test
    void getMaximumGold3() {
        int[][] grid = {{1, 0, 7, 0, 0, 0},
                        {2, 0, 6, 0, 1, 0},
                        {3, 5, 6, 7, 4, 2},
                        {4, 3, 1, 0, 2, 0},
                        {3, 0, 5, 0, 20, 0}};
        Assertions.assertEquals(60, solution.getMaximumGold(grid));
    }

}
