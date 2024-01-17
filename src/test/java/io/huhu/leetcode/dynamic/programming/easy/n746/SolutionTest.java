package io.huhu.leetcode.dynamic.programming.easy.n746;

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
    void minCostClimbingStairs_1() {
        int[] cost = {10, 15, 20};
        Assertions.assertEquals(15, solution.minCostClimbingStairs(cost));
    }

    @Test
    void minCostClimbingStairs_2() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        Assertions.assertEquals(6, solution.minCostClimbingStairs(cost));
    }

    @Test
    void minCostClimbingStairs_3() {
        int[] cost = {0, 2, 2, 1};
        Assertions.assertEquals(2, solution.minCostClimbingStairs(cost));
    }

}
