package io.huhu.leetcode.back.trace.n980;

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
    void uniquePathsIII_1() {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}};
        Assertions.assertEquals(2, solution.uniquePathsIII(grid));
    }

    @Test
    void uniquePathsIII_2() {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}};
        Assertions.assertEquals(4, solution.uniquePathsIII(grid));
    }

    @Test
    void uniquePathsIII_3() {
        int[][] grid = {
                {0, 1},
                {2, 0}};
        Assertions.assertEquals(0, solution.uniquePathsIII(grid));
    }

}
