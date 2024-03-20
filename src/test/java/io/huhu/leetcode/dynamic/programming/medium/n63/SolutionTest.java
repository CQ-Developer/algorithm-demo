package io.huhu.leetcode.dynamic.programming.medium.n63;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void test_1() {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        assertEquals(2, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    void test_2() {
        int[][] obstacleGrid = {
                {0, 1},
                {0, 0}};
        assertEquals(1, solution.uniquePathsWithObstacles(obstacleGrid));
    }

}
