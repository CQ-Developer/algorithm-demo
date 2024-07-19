package io.huhu.leetcode.dynamic.programming.medium.n646;

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
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        Assertions.assertEquals(2, solution.findLongestChain(pairs));
    }

    @Test
    void test_2() {
        int[][] pairs = {{1, 2}, {7, 8}, {4, 5}};
        Assertions.assertEquals(3, solution.findLongestChain(pairs));
    }

}
