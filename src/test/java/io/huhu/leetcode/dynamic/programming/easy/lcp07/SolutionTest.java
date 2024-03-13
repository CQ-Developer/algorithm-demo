package io.huhu.leetcode.dynamic.programming.easy.lcp07;

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
    void test_1() {
        int[][] relation = {
                {0, 2},
                {2, 1},
                {3, 4},
                {2, 3},
                {1, 4},
                {2, 0},
                {0, 4}};
        Assertions.assertEquals(3, solution.numWays(5, relation, 3));
    }

    @Test
    void test_2() {
        int[][] relation = {
                {0, 2},
                {2, 1}};
        Assertions.assertEquals(0, solution.numWays(3, relation, 2));
    }

}