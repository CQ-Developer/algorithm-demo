package io.huhu.leetcode.n63;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @Test
    void uniquePathsWithObstacles_1() {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        assertEquals(2, solution.uniquePathsWithObstacles(obstacleGrid));
    }

    @Test
    void uniquePathsWithObstacles_2() {
        int[][] obstacleGrid = {
                {0, 1},
                {0, 0}};
        assertEquals(1, solution.uniquePathsWithObstacles(obstacleGrid));
    }

}
