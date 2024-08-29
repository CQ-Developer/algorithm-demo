package io.huhu.leetcode.binary.tree.medium.n2477;

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
        int[][] roads = {{0, 1}, {0, 2}, {0, 3}};
        Assertions.assertEquals(3, solution.minimumFuelCost(roads, 5));
    }

    @Test
    void test_2() {
        int[][] roads = {{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        Assertions.assertEquals(7, solution.minimumFuelCost(roads, 2));
    }

    @Test
    void test_3() {
        int[][] roads = {};
        Assertions.assertEquals(0, solution.minimumFuelCost(roads, 1));
    }
    
}
